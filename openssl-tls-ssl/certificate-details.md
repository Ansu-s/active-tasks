# Different components of a TLS/SSL certificate

TO understand lets consider the certificate of www.discord.com that we have extracted using the CLI in the readme.md file.

```shell
root@user:~/hello# openssl x509 -in discord-certificates -noout -text
Certificate:
    Data:
        Version: 3 (0x2)
        Serial Number:
            01:b3:28:51:5e:9c:a6:ea:72:e1:96:bb:55:15:29:3e
        Signature Algorithm: ecdsa-with-SHA256
        Issuer: C = US, O = "Cloudflare, Inc.", CN = Cloudflare Inc ECC CA-3
        Validity
            Not Before: Oct 20 00:00:00 2023 GMT
            Not After : Oct 19 23:59:59 2024 GMT
        Subject: C = US, ST = California, L = San Francisco, O = "Cloudflare, Inc.", CN = discord.com
        Subject Public Key Info:
            Public Key Algorithm: id-ecPublicKey
                Public-Key: (256 bit)
                pub:
                    04:e2:3d:59:59:71:93:fb:8c:f6:73:38:6e:7a:9f:
                    70:7e:2f:2d:8a:73:72:86:cf:98:4e:d5:52:39:78:
                    df:20:ae:d1:9b:65:05:2a:02:83:c6:70:cc:52:cb:
                    e0:be:88:0a:55:0c:4c:cd:51:88:cf:b0:88:97:ea:
                    f3:28:c6:89:b1
                ASN1 OID: prime256v1
                NIST CURVE: P-256
        X509v3 extensions:
            X509v3 Authority Key Identifier:
                A5:CE:37:EA:EB:B0:75:0E:94:67:88:B4:45:FA:D9:24:10:87:96:1F
            X509v3 Subject Key Identifier:
                F6:EB:F9:03:AE:93:28:22:EF:95:0A:4E:51:1B:7E:6B:DA:A5:08:8D
            X509v3 Subject Alternative Name:
                DNS:discord.com, DNS:*.discord.com
            X509v3 Certificate Policies:
                Policy: 2.23.140.1.2.2
                  CPS: http://www.digicert.com/CPS
            X509v3 Key Usage: critical
                Digital Signature, Key Agreement
            X509v3 Extended Key Usage:
                TLS Web Server Authentication, TLS Web Client Authentication
            X509v3 CRL Distribution Points:
                Full Name:
                  URI:http://crl3.digicert.com/CloudflareIncECCCA-3.crl
                Full Name:
                  URI:http://crl4.digicert.com/CloudflareIncECCCA-3.crl
            Authority Information Access:
                OCSP - URI:http://ocsp.digicert.com
                CA Issuers - URI:http://cacerts.digicert.com/CloudflareIncECCCA-3.crt
            X509v3 Basic Constraints: critical
                CA:FALSE
            CT Precertificate SCTs:
                Signed Certificate Timestamp:
                    Version   : v1 (0x0)
                    Log ID    : EE:CD:D0:64:D5:DB:1A:CE:C5:5C:B7:9D:B4:CD:13:A2:
                                32:87:46:7C:BC:EC:DE:C3:51:48:59:46:71:1F:B5:9B
                    Timestamp : Oct 20 02:57:23.774 2023 GMT
                    Extensions: none
                    Signature : ecdsa-with-SHA256
                                30:45:02:20:62:53:68:8D:59:9F:48:B5:40:7A:2A:75:
                                86:4D:FD:AE:24:A5:C1:68:AF:D7:63:5B:22:D6:6C:53:
                                A8:56:97:AA:02:21:00:EC:AE:71:8A:01:0A:46:DC:04:
                                6F:34:D8:B9:95:C3:6C:7A:AD:AD:DE:E7:3A:5F:B3:EC:
                                84:D2:AD:B2:FA:78:7E
                Signed Certificate Timestamp:
                    Version   : v1 (0x0)
                    Log ID    : 48:B0:E3:6B:DA:A6:47:34:0F:E5:6A:02:FA:9D:30:EB:
                                1C:52:01:CB:56:DD:2C:81:D9:BB:BF:AB:39:D8:84:73
                    Timestamp : Oct 20 02:57:23.701 2023 GMT
                    Extensions: none
                    Signature : ecdsa-with-SHA256
                                30:46:02:21:00:C5:94:BF:1C:62:24:DE:84:AA:0A:94:
                                27:D5:CD:40:CC:09:E4:D6:98:C3:CD:18:01:09:3E:C3:
                                AA:05:ED:2D:EE:02:21:00:DF:EB:2F:2F:EA:2A:C6:59:
                                3F:60:2F:CC:A1:7D:43:96:DB:CF:C0:4F:7D:D0:7C:6F:
                                5A:BB:2D:76:0D:23:4E:07
                Signed Certificate Timestamp:
                    Version   : v1 (0x0)
                    Log ID    : DA:B6:BF:6B:3F:B5:B6:22:9F:9B:C2:BB:5C:6B:E8:70:
                                91:71:6C:BB:51:84:85:34:BD:A4:3D:30:48:D7:FB:AB
                    Timestamp : Oct 20 02:57:23.700 2023 GMT
                    Extensions: none
                    Signature : ecdsa-with-SHA256
                                30:45:02:21:00:E8:4F:7D:16:C7:73:0F:26:82:8B:CC:
                                54:5E:A8:3C:89:2E:C2:E3:47:CF:2D:5E:8D:F5:93:53:
                                F8:E1:60:22:34:02:20:36:D0:2B:1F:5E:AC:B8:19:06:
                                1F:B9:3C:CF:8B:8E:28:73:38:A7:07:F1:41:3E:28:E7:
                                CF:3C:AE:2C:24:E8:A9
    Signature Algorithm: ecdsa-with-SHA256
    Signature Value:
        30:45:02:21:00:84:69:c8:32:13:18:bf:a0:ff:7c:64:4e:b4:
        4c:54:66:11:b6:65:cb:89:14:cb:74:a6:52:2b:cb:53:53:ce:
        9c:02:20:38:01:69:b2:dc:64:d0:a0:73:30:d3:61:8f:af:0c:
        ad:0e:4d:70:61:19:f6:cf:7c:ed:4f:85:db:6c:64:c0:5f
```  
  
### Version 
`Version: 3 (0x2)` This is the version of the ssl certificate, Currently we have only 3 versions. Any updates post version 3 are added in the form of extensions.
  
### Serial NO. 
` Serial Number: 01:b3:28:51:5e:9c:a6:ea:72:e1:96:bb:55:15:29:3e` It is the serial number of the certificate which is provided by the issuer
  
### Signature Algorithm
` Signature Algorithm: ecdsa-with-SHA256` This tells which algorithm is used to encrypt the key in this certificate
  
### Certificate Authority (CA)
`  Issuer: C = US, O = "Cloudflare, Inc.", CN = Cloudflare Inc ECC CA-3` It provided information about the issuer of certificate, or it's the CA  
### Validity 
`Validity
Not Before: Oct 20 00:00:00 2023 GMT
Not After : Oct 19 23:59:59 2024 GMT`  
The validity sets the expiry of the certificate, Not Before and Not After sets a specific period within which only the certificate will be valid to use.  
### Subject  
` Subject: C = US, ST = California, L = San Francisco, O = "Cloudflare, Inc.", CN = discord.com` This specifies to whom the certificate if issued to or who can use this certificate. Common Name(CN) tells for whom the certificate affirms identity for.  
### Subject Public Key  
```
Subject Public Key Info:
Public Key Algorithm: id-ecPublicKey
Public-Key: (256 bit)
pub:
04:e2:3d:59:59:71:93:fb:8c:f6:73:38:6e:7a:9f:
70:7e:2f:2d:8a:73:72:86:cf:98:4e:d5:52:39:78:
df:20:ae:d1:9b:65:05:2a:02:83:c6:70:cc:52:cb:
e0:be:88:0a:55:0c:4c:cd:51:88:cf:b0:88:97:ea:
f3:28:c6:89:b1
ASN1 OID: prime256v1
NIST CURVE: P-256 
```

This is the public key of the requested server or to whom the certificate is issued to which is discord in our case.

### Extensions  
```shell
  X509v3 extensions:
            X509v3 Authority Key Identifier:
                A5:CE:37:EA:EB:B0:75:0E:94:67:88:B4:45:FA:D9:24:10:87:96:1F
            X509v3 Subject Key Identifier:
                F6:EB:F9:03:AE:93:28:22:EF:95:0A:4E:51:1B:7E:6B:DA:A5:08:8D
            X509v3 Subject Alternative Name:
                DNS:discord.com, DNS:*.discord.com
            X509v3 Certificate Policies:
                Policy: 2.23.140.1.2.2
                  CPS: http://www.digicert.com/CPS
            X509v3 Key Usage: critical
                Digital Signature, Key Agreement
            X509v3 Extended Key Usage:
                TLS Web Server Authentication, TLS Web Client Authentication
            X509v3 CRL Distribution Points:
                Full Name:
                  URI:http://crl3.digicert.com/CloudflareIncECCCA-3.crl
                Full Name:
                  URI:http://crl4.digicert.com/CloudflareIncECCCA-3.crl
```  

These are the additional functionalities added to the version 3 of the openssl specification  

### Subject Alternative Name  
` X509v3 Subject Alternative Name: DNS:discord.com, DNS:*.discord.com` It is the SAN which is used to identify to which domains this certificate can be issued to  

### Certificate Usage
`  X509v3 Key Usage: critical
Digital Signature, Key Agreement
X509v3 Extended Key Usage:
TLS Web Server Authentication, TLS Web Client Authentication` This is used to identify the purpose of the ssl certificate  

### Certificate Revocation List(CRL)  
```shell
 X509v3 CRL Distribution Points:
                Full Name:
                  URI:http://crl3.digicert.com/CloudflareIncECCCA-3.crl
                Full Name:
                  URI:http://crl4.digicert.com/CloudflareIncECCCA-3.crl
            Authority Information Access:
                OCSP - URI:http://ocsp.digicert.com
                CA Issuers - URI:http://cacerts.digicert.com/CloudflareIncECCCA-3.crt
```  
This is used to revoke the issued certificates, when the browser receives the certificate it downloads the CRL list and checks the certificate with list to check its validity, currently the OCSP is used to check validation  
### Authority Information Access
```
 Authority Information Access:
                OCSP - URI:http://ocsp.digicert.com
                CA Issuers - URI:http://cacerts.digicert.com/CloudflareIncECCCA-3.crt
```  
This tell information about the CA parent Authority, Since in our case the CA is not the root CA so we have this field available for the intermediate CA  
### Certificate Transparency Section  
```shell
CT Precertificate SCTs:
                Signed Certificate Timestamp:
                    Version   : v1 (0x0)
                    Log ID    : EE:CD:D0:64:D5:DB:1A:CE:C5:5C:B7:9D:B4:CD:13:A2:
                                32:87:46:7C:BC:EC:DE:C3:51:48:59:46:71:1F:B5:9B
                    Timestamp : Oct 20 02:57:23.774 2023 GMT
                    Extensions: none
                    Signature : ecdsa-with-SHA256
                                30:45:02:20:62:53:68:8D:59:9F:48:B5:40:7A:2A:75:
                                86:4D:FD:AE:24:A5:C1:68:AF:D7:63:5B:22:D6:6C:53:
                                A8:56:97:AA:02:21:00:EC:AE:71:8A:01:0A:46:DC:04:
                                6F:34:D8:B9:95:C3:6C:7A:AD:AD:DE:E7:3A:5F:B3:EC:
                                84:D2:AD:B2:FA:78:7E
                Signed Certificate Timestamp:
                    Version   : v1 (0x0)
                    Log ID    : 48:B0:E3:6B:DA:A6:47:34:0F:E5:6A:02:FA:9D:30:EB:
                                1C:52:01:CB:56:DD:2C:81:D9:BB:BF:AB:39:D8:84:73
                    Timestamp : Oct 20 02:57:23.701 2023 GMT
                    Extensions: none
                    Signature : ecdsa-with-SHA256
                                30:46:02:21:00:C5:94:BF:1C:62:24:DE:84:AA:0A:94:
                                27:D5:CD:40:CC:09:E4:D6:98:C3:CD:18:01:09:3E:C3:
                                AA:05:ED:2D:EE:02:21:00:DF:EB:2F:2F:EA:2A:C6:59:
                                3F:60:2F:CC:A1:7D:43:96:DB:CF:C0:4F:7D:D0:7C:6F:
                                5A:BB:2D:76:0D:23:4E:07
                Signed Certificate Timestamp:
                    Version   : v1 (0x0)
                    Log ID    : DA:B6:BF:6B:3F:B5:B6:22:9F:9B:C2:BB:5C:6B:E8:70:
                                91:71:6C:BB:51:84:85:34:BD:A4:3D:30:48:D7:FB:AB
                    Timestamp : Oct 20 02:57:23.700 2023 GMT
                    Extensions: none
                    Signature : ecdsa-with-SHA256
                                30:45:02:21:00:E8:4F:7D:16:C7:73:0F:26:82:8B:CC:
                                54:5E:A8:3C:89:2E:C2:E3:47:CF:2D:5E:8D:F5:93:53:
                                F8:E1:60:22:34:02:20:36:D0:2B:1F:5E:AC:B8:19:06:
                                1F:B9:3C:CF:8B:8E:28:73:38:A7:07:F1:41:3E:28:E7:
                                CF:3C:AE:2C:24:E8:A9
``` 
This section show in which public domains are these certificates are registered so anyone can access them  
### Certificate Signature
```shell
 Signature Algorithm: ecdsa-with-SHA256
    Signature Value:
        30:45:02:21:00:84:69:c8:32:13:18:bf:a0:ff:7c:64:4e:b4:
        4c:54:66:11:b6:65:cb:89:14:cb:74:a6:52:2b:cb:53:53:ce:
        9c:02:20:38:01:69:b2:dc:64:d0:a0:73:30:d3:61:8f:af:0c:
        ad:0e:4d:70:61:19:f6:cf:7c:ed:4f:85:db:6c:64:c0:5f
```  
The CA take the contents of the certificate and encrypts it with its algorithm which is SHA256