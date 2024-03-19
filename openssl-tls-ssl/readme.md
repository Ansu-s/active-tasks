### Extracting Certificates using Command Line in Linux

1. I used the openssl ubuntu command to send a connect to website and capture its ssl information.

```shell
root@user:~/hello# openssl s_client www.discord.com:443
CONNECTED(00000003)
depth=2 C = IE, O = Baltimore, OU = CyberTrust, CN = Baltimore CyberTrust Root
verify return:1
depth=1 C = US, O = "Cloudflare, Inc.", CN = Cloudflare Inc ECC CA-3
verify return:1
depth=0 C = US, ST = California, L = San Francisco, O = "Cloudflare, Inc.", CN = discord.com
verify return:1
---
Certificate chain
 0 s:C = US, ST = California, L = San Francisco, O = "Cloudflare, Inc.", CN = discord.com
   i:C = US, O = "Cloudflare, Inc.", CN = Cloudflare Inc ECC CA-3
   a:PKEY: id-ecPublicKey, 256 (bit); sigalg: ecdsa-with-SHA256
   v:NotBefore: Oct 20 00:00:00 2023 GMT; NotAfter: Oct 19 23:59:59 2024 GMT
 1 s:C = US, O = "Cloudflare, Inc.", CN = Cloudflare Inc ECC CA-3
   i:C = IE, O = Baltimore, OU = CyberTrust, CN = Baltimore CyberTrust Root
   a:PKEY: id-ecPublicKey, 256 (bit); sigalg: RSA-SHA256
   v:NotBefore: Jan 27 12:48:08 2020 GMT; NotAfter: Dec 31 23:59:59 2024 GMT
---
Server certificate
-----BEGIN CERTIFICATE-----
MIIFFTCCBLugAwIBAgIQAbMoUV6cpupy4Za7VRUpPjAKBggqhkjOPQQDAjBKMQsw
CQYDVQQGEwJVUzEZMBcGA1UEChMQQ2xvdWRmbGFyZSwgSW5jLjEgMB4GA1UEAxMX
Q2xvdWRmbGFyZSBJbmMgRUNDIENBLTMwHhcNMjMxMDIwMDAwMDAwWhcNMjQxMDE5
MjM1OTU5WjBrMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQG
A1UEBxMNU2FuIEZyYW5jaXNjbzEZMBcGA1UEChMQQ2xvdWRmbGFyZSwgSW5jLjEU
MBIGA1UEAxMLZGlzY29yZC5jb20wWTATBgcqhkjOPQIBBggqhkjOPQMBBwNCAATi
PVlZcZP7jPZzOG56n3B+Ly2Kc3KGz5hO1VI5eN8grtGbZQUqAoPGcMxSy+C+iApV
DEzNUYjPsIiX6vMoxomxo4IDYDCCA1wwHwYDVR0jBBgwFoAUpc436uuwdQ6UZ4i0
RfrZJBCHlh8wHQYDVR0OBBYEFPbr+QOukygi75UKTlEbfmvapQiNMCUGA1UdEQQe
MByCC2Rpc2NvcmQuY29tgg0qLmRpc2NvcmQuY29tMD4GA1UdIAQ3MDUwMwYGZ4EM
AQICMCkwJwYIKwYBBQUHAgEWG2h0dHA6Ly93d3cuZGlnaWNlcnQuY29tL0NQUzAO
BgNVHQ8BAf8EBAMCA4gwHQYDVR0lBBYwFAYIKwYBBQUHAwEGCCsGAQUFBwMCMHsG
A1UdHwR0MHIwN6A1oDOGMWh0dHA6Ly9jcmwzLmRpZ2ljZXJ0LmNvbS9DbG91ZGZs
YXJlSW5jRUNDQ0EtMy5jcmwwN6A1oDOGMWh0dHA6Ly9jcmw0LmRpZ2ljZXJ0LmNv
bS9DbG91ZGZsYXJlSW5jRUNDQ0EtMy5jcmwwdgYIKwYBBQUHAQEEajBoMCQGCCsG
AQUFBzABhhhodHRwOi8vb2NzcC5kaWdpY2VydC5jb20wQAYIKwYBBQUHMAKGNGh0
dHA6Ly9jYWNlcnRzLmRpZ2ljZXJ0LmNvbS9DbG91ZGZsYXJlSW5jRUNDQ0EtMy5j
cnQwDAYDVR0TAQH/BAIwADCCAX8GCisGAQQB1nkCBAIEggFvBIIBawFpAHYA7s3Q
ZNXbGs7FXLedtM0TojKHRny87N7DUUhZRnEftZsAAAGLSwQhPgAABAMARzBFAiBi
U2iNWZ9ItUB6KnWGTf2uJKXBaK/XY1si1mxTqFaXqgIhAOyucYoBCkbcBG802LmV
w2x6ra3e5zpfs+yE0q2y+nh+AHcASLDja9qmRzQP5WoC+p0w6xxSActW3SyB2bu/
qznYhHMAAAGLSwQg9QAABAMASDBGAiEAxZS/HGIk3oSqCpQn1c1AzAnk1pjDzRgB
CT7DqgXtLe4CIQDf6y8v6irGWT9gL8yhfUOW28/AT33QfG9auy12DSNOBwB2ANq2
v2s/tbYin5vCu1xr6HCRcWy7UYSFNL2kPTBI1/urAAABi0sEIPQAAAQDAEcwRQIh
AOhPfRbHcw8mgovMVF6oPIkuwuNHzy1ejfWTU/jhYCI0AiA20CsfXqy4GQYfuTzP
i44oczinB/FBPijnzzyuLCToqTAKBggqhkjOPQQDAgNIADBFAiEAhGnIMhMYv6D/
fGROtExUZhG2ZcuJFMt0plIry1NTzpwCIDgBabLcZNCgczDTYY+vDK0OTXBhGfbP
fO1PhdtsZMBf
-----END CERTIFICATE-----
subject=C = US, ST = California, L = San Francisco, O = "Cloudflare, Inc.", CN = discord.com
issuer=C = US, O = "Cloudflare, Inc.", CN = Cloudflare Inc ECC CA-3
---
No client certificate CA names sent
Peer signing digest: SHA256
Peer signature type: ECDSA
Server Temp Key: X25519, 253 bits
---
SSL handshake has read 2597 bytes and written 397 bytes
Verification: OK
---
New, TLSv1.3, Cipher is TLS_AES_256_GCM_SHA384
Server public key is 256 bit
Secure Renegotiation IS NOT supported
Compression: NONE
Expansion: NONE
No ALPN negotiated
Early data was not sent
Verify return code: 0 (ok)
---
---
Post-Handshake New Session Ticket arrived:
SSL-Session:
    Protocol  : TLSv1.3
    Cipher    : TLS_AES_256_GCM_SHA384
    Session-ID: D56D6944264696C3A5E32A0B1D9039D046EF1EE562561402D7D387339B638487
    Session-ID-ctx:
    Resumption PSK: 36C8A4AE0CA340BB7202EB1B79BDEF86EE1E7DC04FC64131B0ACCA13C326C95D6D5AC3DFD8E4BB79A0391E090056FC68
    PSK identity: None
    PSK identity hint: None
    SRP username: None
    TLS session ticket lifetime hint: 64800 (seconds)
    TLS session ticket:
    0000 - 20 a4 5d f5 37 39 35 88-99 1a 85 7d 51 fe 64 3a    .].795....}Q.d:
    0010 - 6c 45 3e d2 24 65 a4 3e-5b 1b 89 cf e2 98 d0 e2   lE>.$e.>[.......
    0020 - 60 11 af 08 3f 40 d0 e1-d6 1e a1 a5 da bc b7 95   `...?@..........
    0030 - de 66 9a a1 da b8 30 30-1a 9c 29 1d 39 a5 c5 6b   .f....00..).9..k
    0040 - c2 16 b5 d9 02 1c 22 16-8a 72 b0 58 97 62 44 8c   ......"..r.X.bD.
    0050 - bb 0a 97 c4 87 fd 9e 89-95 56 94 c2 58 e9 4f 05   .........V..X.O.
    0060 - fe 39 8d 4c 1c 69 bf 85-ab 88 c4 68 0a 54 3e cf   .9.L.i.....h.T>.
    0070 - e2 24 c0 d3 16 02 c3 01-00 c6 07 92 72 49 d4 d9   .$..........rI..
    0080 - bd 77 23 fd 8f f0 86 af-fe fa 95 e7 73 e8 b5 8b   .w#.........s...
    0090 - f7 8c 1f bb 98 6e fe 1f-7c e7 91 63 a2 e9 65 a1   .....n..|..c..e.
    00a0 - 3e 32 a8 6c 04 72 3f 96-c2 e8 71 3f b0 19 1c dd   >2.l.r?...q?....
    00b0 - 14 28 73 d0 9a 2d dc b6-8c b5 1c 69 6a 08 18 f3   .(s..-.....ij...
    00c0 - 3d 2d 0e 95 6c fe 9d 5f-dd da ba 5e 53 80 50 5a   =-..l.._...^S.PZ

    Start Time: 1710841465
    Timeout   : 7200 (sec)
    Verify return code: 0 (ok)
    Extended master secret: no
    Max Early Data: 14336
---
read R BLOCK
---
Post-Handshake New Session Ticket arrived:
SSL-Session:
    Protocol  : TLSv1.3
    Cipher    : TLS_AES_256_GCM_SHA384
    Session-ID: 4DABED767B9FBF15A4A7BFB89C8E72E3D37BC589AF677899D6CAD2F515C100B7
    Session-ID-ctx:
    Resumption PSK: 8C7C24CBC519A65E24C26FF13784E5510D5671A7FFB8CBC85B218B4404CA119CEF24925EA82B0CE3FA6BDE173C0347B6
    PSK identity: None
    PSK identity hint: None
    SRP username: None
    TLS session ticket lifetime hint: 64800 (seconds)
    TLS session ticket:
    0000 - 20 a4 5d f5 37 39 35 88-99 1a 85 7d 51 fe 64 3a    .].795....}Q.d:
    0010 - 96 f3 ae d5 c8 97 94 40-9a 1c 34 a5 d7 e6 40 93   .......@..4...@.
    0020 - 93 a6 36 61 c2 90 ef 2e-a6 8f c8 ef fa 45 e7 10   ..6a.........E..
    0030 - 3e 6c be 72 00 f9 f8 70-eb 8e a3 e3 02 d6 f8 2e   >l.r...p........
    0040 - 1a eb b5 d5 1e 66 14 da-51 c0 cb d7 e0 9f 1e 0e   .....f..Q.......
    0050 - 63 16 8e cc 38 93 46 3c-a3 24 cf 54 aa f8 f6 3e   c...8.F<.$.T...>
    0060 - 46 3f 61 2b c8 c3 af 3e-57 44 50 6b c1 7a 83 54   F?a+...>WDPk.z.T
    0070 - 2b 63 57 6b 2f ab c7 a6-eb cf 6c 4c 61 34 96 22   +cWk/.....lLa4."
    0080 - bc 95 13 ea b4 6f 0c ee-e0 f9 08 71 17 bc c1 4f   .....o.....q...O
    0090 - b0 5e b0 b1 8b af 00 3f-7d e0 28 99 d5 5f 33 fd   .^.....?}.(.._3.
    00a0 - 11 1e 02 b5 5e 0f 23 30-eb 0f cb e0 5d 23 09 c5   ....^.#0....]#..
    00b0 - 83 37 ad 85 fb c3 87 c9-54 fd 76 1b c0 c8 80 3d   .7......T.v....=
    00c0 - 0a 8c 84 51 18 c6 c6 bf-95 fb 17 f9 41 f1 ad 97   ...Q........A...

    Start Time: 1710841466
    Timeout   : 7200 (sec)
    Verify return code: 0 (ok)
    Extended master secret: no
    Max Early Data: 14336
---
read R BLOCK
closed
```
2. Saved the certificate part in a new file using vim
```shell
root@user:~/hello# vim discord-certificates
root@user:~/hello# cat discord-certificates
-----BEGIN CERTIFICATE-----
MIIFFTCCBLugAwIBAgIQAbMoUV6cpupy4Za7VRUpPjAKBggqhkjOPQQDAjBKMQsw
CQYDVQQGEwJVUzEZMBcGA1UEChMQQ2xvdWRmbGFyZSwgSW5jLjEgMB4GA1UEAxMX
Q2xvdWRmbGFyZSBJbmMgRUNDIENBLTMwHhcNMjMxMDIwMDAwMDAwWhcNMjQxMDE5
MjM1OTU5WjBrMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQG
A1UEBxMNU2FuIEZyYW5jaXNjbzEZMBcGA1UEChMQQ2xvdWRmbGFyZSwgSW5jLjEU
MBIGA1UEAxMLZGlzY29yZC5jb20wWTATBgcqhkjOPQIBBggqhkjOPQMBBwNCAATi
PVlZcZP7jPZzOG56n3B+Ly2Kc3KGz5hO1VI5eN8grtGbZQUqAoPGcMxSy+C+iApV
DEzNUYjPsIiX6vMoxomxo4IDYDCCA1wwHwYDVR0jBBgwFoAUpc436uuwdQ6UZ4i0
RfrZJBCHlh8wHQYDVR0OBBYEFPbr+QOukygi75UKTlEbfmvapQiNMCUGA1UdEQQe
MByCC2Rpc2NvcmQuY29tgg0qLmRpc2NvcmQuY29tMD4GA1UdIAQ3MDUwMwYGZ4EM
AQICMCkwJwYIKwYBBQUHAgEWG2h0dHA6Ly93d3cuZGlnaWNlcnQuY29tL0NQUzAO
BgNVHQ8BAf8EBAMCA4gwHQYDVR0lBBYwFAYIKwYBBQUHAwEGCCsGAQUFBwMCMHsG
A1UdHwR0MHIwN6A1oDOGMWh0dHA6Ly9jcmwzLmRpZ2ljZXJ0LmNvbS9DbG91ZGZs
YXJlSW5jRUNDQ0EtMy5jcmwwN6A1oDOGMWh0dHA6Ly9jcmw0LmRpZ2ljZXJ0LmNv
bS9DbG91ZGZsYXJlSW5jRUNDQ0EtMy5jcmwwdgYIKwYBBQUHAQEEajBoMCQGCCsG
AQUFBzABhhhodHRwOi8vb2NzcC5kaWdpY2VydC5jb20wQAYIKwYBBQUHMAKGNGh0
dHA6Ly9jYWNlcnRzLmRpZ2ljZXJ0LmNvbS9DbG91ZGZsYXJlSW5jRUNDQ0EtMy5j
cnQwDAYDVR0TAQH/BAIwADCCAX8GCisGAQQB1nkCBAIEggFvBIIBawFpAHYA7s3Q
ZNXbGs7FXLedtM0TojKHRny87N7DUUhZRnEftZsAAAGLSwQhPgAABAMARzBFAiBi
U2iNWZ9ItUB6KnWGTf2uJKXBaK/XY1si1mxTqFaXqgIhAOyucYoBCkbcBG802LmV
w2x6ra3e5zpfs+yE0q2y+nh+AHcASLDja9qmRzQP5WoC+p0w6xxSActW3SyB2bu/
qznYhHMAAAGLSwQg9QAABAMASDBGAiEAxZS/HGIk3oSqCpQn1c1AzAnk1pjDzRgB
CT7DqgXtLe4CIQDf6y8v6irGWT9gL8yhfUOW28/AT33QfG9auy12DSNOBwB2ANq2
v2s/tbYin5vCu1xr6HCRcWy7UYSFNL2kPTBI1/urAAABi0sEIPQAAAQDAEcwRQIh
AOhPfRbHcw8mgovMVF6oPIkuwuNHzy1ejfWTU/jhYCI0AiA20CsfXqy4GQYfuTzP
i44oczinB/FBPijnzzyuLCToqTAKBggqhkjOPQQDAgNIADBFAiEAhGnIMhMYv6D/
fGROtExUZhG2ZcuJFMt0plIry1NTzpwCIDgBabLcZNCgczDTYY+vDK0OTXBhGfbP
fO1PhdtsZMBf
-----END CERTIFICATE-----
```  
3. Since the above certificate is in base64 encoded format we need to convert it into readable format using the openssl utility

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