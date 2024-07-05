package com.example.fileprocessor.client;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

@Log4j2
public class CustomClientHttpRequestFactory extends SimpleClientHttpRequestFactory {

    private static final HostnameVerifier PROMISCUOUS_VERIFIER = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    private static final TrustManager[] ALL_CERT_TRUST_MANAGER = new TrustManager[] {
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {

                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {

                }
            }
    };

    private static SSLContext ALL_CERT_TRUST_SSLCONTEXT = null;

    static {
        try {
            ALL_CERT_TRUST_SSLCONTEXT = SSLContext.getInstance("SSL");
            ALL_CERT_TRUST_SSLCONTEXT.init(null, ALL_CERT_TRUST_MANAGER, new SecureRandom());
        } catch (Exception e) {
            System.out.println("Exceeption: ");
            e.printStackTrace();
//            log.error("Error disabling SSL verification");
//            log.error(e.getMessage(), e);
        }
    }


    private boolean disableSslVerification = false;

    public CustomClientHttpRequestFactory(int connectTimeout, int readTimeout, boolean disableSslVerification) {
        this.setConnectTimeout(connectTimeout);
        this.setReadTimeout(readTimeout);
        this.disableSslVerification = disableSslVerification;
    }

    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
        if (disableSslVerification && ALL_CERT_TRUST_SSLCONTEXT != null && connection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) connection).setHostnameVerifier(PROMISCUOUS_VERIFIER);
            ((HttpsURLConnection) connection).setSSLSocketFactory(ALL_CERT_TRUST_SSLCONTEXT.getSocketFactory());
        }
        super.prepareConnection(connection, httpMethod);
    }

}