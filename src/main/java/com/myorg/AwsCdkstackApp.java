package com.myorg;

import software.amazon.awscdk.core.App;

import java.util.Arrays;

public class AwsCdkstackApp {
    public static void main(final String[] args) {
        App app = new App();

        new AwsCdkstackStack(app, "AwsCdkstackStack");

        app.synth();
    }
}
