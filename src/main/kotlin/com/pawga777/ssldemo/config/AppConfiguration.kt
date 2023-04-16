package com.pawga777.ssldemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.*


/**
 * Created by sivannikov on 30.01.2023 21:24
 */

@Configuration
class AppConfiguration {

    // https://myshittycode.com/2015/12/17/java-https-unable-to-find-valid-certification-path-to-requested-target-2/

    @Bean
    @Throws(Exception::class)
    fun disableSSLValidation(): Boolean {
        val sslContext = SSLContext.getInstance("TLS")

        sslContext.init(null, arrayOf<TrustManager>(object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(x509Certificates: Array<X509Certificate>, s: String) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(x509Certificates: Array<X509Certificate>, s: String) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate?> {
                return arrayOfNulls(0)
            }
        }), null)
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.socketFactory)
        HttpsURLConnection.setDefaultHostnameVerifier { _, _ -> true }
        return true
    }
}