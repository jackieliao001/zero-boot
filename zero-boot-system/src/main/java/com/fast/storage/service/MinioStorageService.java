package com.fast.storage.service;

import com.fast.framework.common.exception.ServerException;
import com.fast.storage.properties.StorageProperties;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Minio存储
 *
 * @author liaojunjie
 * @date 2023/2/15
 */
public class MinioStorageService extends StorageService {
    private final MinioClient minioClient;

    public MinioStorageService(StorageProperties properties) {
        this.properties = properties;

        minioClient = MinioClient.builder().endpoint(properties.getMinio().getEndPoint())
                .credentials(properties.getMinio().getAccessKey(), properties.getMinio().getSecretKey()).build();
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            //如果BucketName不存在，则创建
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(properties.getMinio().getBucketName()).build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(properties.getMinio().getBucketName()).build());
            }

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(properties.getMinio().getBucketName())
                            .object(path)
                            .stream(inputStream, inputStream.available(), -1)
                            .build()
            );

        } catch (Exception e) {
            throw new ServerException("上传文件失败：", e);
        }

        return properties.getMinio().getEndPoint() + "/" + properties.getMinio().getBucketName() + "/" + path;
    }
}
