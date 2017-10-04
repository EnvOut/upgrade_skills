package com.tow.spring.xml;

import java.security.MessageDigest;

import static java.lang.System.out;

public class MessageDigester {
    private MessageDigest digest1;
    private MessageDigest digest2;

    public void digest(String msg) {
        out.println("Using digets1");
        digest(msg, digest1);

        out.println("Using digest2");
        digest(msg, digest2);
    }

    private void digest(String msg, MessageDigest digest) {
        out.println("Using algorithm: " + digest.getAlgorithm());
        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] outDigest = digest.digest(bytes);
        out.println(outDigest);
    }

    public void setDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }

    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }

}
