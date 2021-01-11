package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.codecommit.Repository;
import software.amazon.awscdk.services.s3.BlockPublicAccess;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketEncryption;

public class AwsCdkstackStack extends Stack {
    public AwsCdkstackStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public AwsCdkstackStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // 履歴書のソースリポジトリの作成
        final Repository resumeSourceRepo =
                Repository.Builder.create(this, "cv-repo").repositoryName("resume-cv-repo").description("職務経歴書・履歴書のソースレポジトリ").build();

        // ビルド成果物の格納先を作成
        final Bucket bucket = Bucket.Builder.create(this, "resume-storage")
                .bucketName("my-resume-document-storage")
                .blockPublicAccess(BlockPublicAccess.BLOCK_ALL)
                .versioned(true)
                .encryption(BucketEncryption.S3_MANAGED)
                .build();
    }
}
