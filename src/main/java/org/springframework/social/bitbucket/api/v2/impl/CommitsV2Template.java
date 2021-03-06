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
package org.springframework.social.bitbucket.api.v2.impl;

import org.springframework.social.bitbucket.api.impl.AbstractBitBucketOperations;
import org.springframework.social.bitbucket.api.v2.CommitsV2Operations;
import org.springframework.social.bitbucket.api.v2.payload.BitBucketV2Commit;
import org.springframework.web.client.RestTemplate;

public class CommitsV2Template extends AbstractBitBucketOperations
        implements CommitsV2Operations {

    public CommitsV2Template(RestTemplate restTemplate, boolean authorized) {
        super(restTemplate, authorized, V2);
    }

    @Override
    public BitBucketV2Commit getCommit(String owner, String repoSlug,
            String node) {
        return getRestTemplate().getForObject(
                buildUrl("/repositories/{owner}/{repo}/commit/{node}"),
                BitBucketV2Commit.class, owner, repoSlug, node);
    }

}
