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
package org.springframework.social.bitbucket.api.v2.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketV2Commit {

    @JsonProperty
    private String hash;

    @JsonProperty
    private BitBucketV2Commit.LinkList links;

    @JsonProperty
    private BitBucketV2Commit.Author author;

    @JsonProperty
    private Summary summary;

    @JsonProperty
    private List<Participant> participants;

    @JsonProperty
    private String date;

    @JsonProperty
    private String message;

    public final String getHash() {
        return hash;
    }

    public final BitBucketV2Commit.LinkList getLinks() {
        return links;
    }

    public final BitBucketV2Commit.Author getAuthor() {
        return author;
    }

    public final Summary getSummary() {
        return summary;
    }

    public final List<Participant> getParticipants() {
        return participants;
    }

    public final String getDate() {
        return date;
    }

    public final String getMessage() {
        return message;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LinkList {

        @JsonProperty
        private Link self;

        @JsonProperty
        private Link comments;

        @JsonProperty
        private Link patch;

        @JsonProperty
        private Link html;

        @JsonProperty
        private Link diff;

        @JsonProperty
        private Link approve;

        @JsonProperty
        private Link statuses;

        public final Link getSelf() {
            return self;
        }

        public final Link getComments() {
            return comments;
        }

        public final Link getPatch() {
            return patch;
        }

        public final Link getHtml() {
            return html;
        }

        public final Link getDiff() {
            return diff;
        }

        public final Link getApprove() {
            return approve;
        }

        public final Link getStatuses() {
            return statuses;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User {
        @JsonProperty
        private String username;

        @JsonProperty("display_name")
        private String displayName;

        @JsonProperty
        private String uuid;

        public final String getUsername() {
            return username;
        }

        public final String getDisplayName() {
            return displayName;
        }

        public final String getUuid() {
            return uuid;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Author {
        @JsonProperty
        private String raw;

        @JsonProperty
        private User user;

        public final String getRaw() {
            return raw;
        }

        public final User getUser() {
            return user;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Participant {
        @JsonProperty
        private String role;

        @JsonProperty("participated_on")
        private String participatedOn;

        @JsonProperty
        private Boolean approved;

        @JsonProperty
        private User user;

        public final String getRole() {
            return role;
        }

        public final String getParticipatedOn() {
            return participatedOn;
        }

        public final Boolean getApproved() {
            return approved;
        }

        public final User getUser() {
            return user;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Summary {
        @JsonProperty
        private String raw;

        @JsonProperty
        private String markup;

        public final String getRaw() {
            return raw;
        }

        public final String getMarkup() {
            return markup;
        }

    }
}
