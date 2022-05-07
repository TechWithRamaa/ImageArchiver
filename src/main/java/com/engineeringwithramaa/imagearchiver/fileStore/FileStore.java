package com.engineeringwithramaa.imagearchiver.fileStore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class FileStore {

    private AmazonS3 s3;

    @Autowired
    public FileStore(AmazonS3 s3) {
        this.s3 = s3;
    }

    public void save(String path,
                     String fileName,
                     Optional<Map<String, String>> optionalMetaData,
                     InputStream inputStream
                     ) {
        ObjectMetadata metaData = new ObjectMetadata();
        optionalMetaData.ifPresent(map -> {
            if(!map.isEmpty()) {
                map.forEach(metaData::addUserMetadata);
            }
        });

        try {
                s3.putObject(path,fileName, inputStream, metaData);
        }catch(AmazonServiceException e) {
                throw new IllegalStateException("Failed to store image to S3 ", e);
        }

    }

}
