/**
 * Copyright (C) 2012 Eric Bottard / Guillaume Lederrey (eric.bottard+ghpublic@gmail.com / guillaume.lederrey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.bitbucket.api.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.social.bitbucket.api.BitBucketPrivilege;
import org.springframework.social.bitbucket.api.PrivilegeOperations;
import org.springframework.social.bitbucket.api.RepoPrivilege;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

public class PrivilegeTemplate extends AbstractBitBucketOperations implements
        PrivilegeOperations {

    public PrivilegeTemplate(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V1);
    }

    @Override
    public final List<RepoPrivilege> getRepoPrivileges(String user, String repoSlug) {
        return asList(getRestTemplate().getForObject(
                buildUrl("/privileges/{accountname}/{repo_slug}"),
                RepoPrivilege[].class, user, repoSlug));
    }

    @Override
    public final List<RepoPrivilege> getPrivilegesForAnIndividual(String accountName, String repoSlug, String privilegeAccount) {
        return asList(getRestTemplate().getForObject(
                buildUrl("/privileges/{accountname}/{repo_slug}"),
                RepoPrivilege[].class, accountName, repoSlug));
    }

    @Override
    public final List<RepoPrivilege> getPrivilegesAcrossAllRepositories(String accountName) {
        return asList(getRestTemplate().getForObject(buildUrl("/privileges/{accountname}"),
                RepoPrivilege[].class, accountName));
    }

    @Override
    public final RepoPrivilege setPrivilege(String accountName, String repoSlug,
                                            String recipient, BitBucketPrivilege privilege) {
        return getRestTemplate().exchange(
                buildUrl("/privileges/{accountname}/{repo_slug}/{recipient}"),
                HttpMethod.PUT, new HttpEntity<String>(privilege.toString()),
                RepoPrivilege[].class, accountName, repoSlug, recipient).getBody()[0];
    }

    @Override
    public final void removePrivilege(String accountName, String repoSlug, String recipient) {
        getRestTemplate().delete(buildUrl("/privileges/{accountname}/{repo_slug}/{recipient}"), accountName,
                repoSlug, recipient);
    }

    @Override
    public final void removeAllPrivilegesFromARepository(String accountName, String repoSlug) {
        getRestTemplate().delete(buildUrl("/privileges/{accountname}/{repo_slug}"), accountName, repoSlug);
    }

    @Override
    public final void removeAllPrivilegesFromAllRepositories(String accountName) {
        getRestTemplate().delete(buildUrl("/privileges/{accountname}"), accountName);
    }

}
