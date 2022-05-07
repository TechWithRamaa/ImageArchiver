package com.engineeringwithramaa.imagearchiver.bucket;

public enum BucketName {

    PROFILE_IMAGE("engineeringwithramaa-image-archiver");

    private final String bucketName;
    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }
    public String getBucketName() {
        return bucketName;
    }

}