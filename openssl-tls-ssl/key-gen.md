# TLS/SSL key generation using openssl  
- To generate a key pair using openssl we use the below command 
```shell
openssl genrsa -out key-pair.pem 2048 
```  
- To extract the public key form the above generated key we use
```shell
openssl rsa -in key-pair.pem -pubout -out public-key.pem
``` 
- To crete a Certificate Signing Request(CSR) to request for a digital certificate to the Certificate Authority using openssl
```shell
openssl req -new -key key-pair.pem -out certificate.csr
``` 
- To  create a Self-Signed Certificate we can provide the above generated csr file and the private key
```shell
openssl x509 -req -days 365 -in certificate.csr -signkey key-pair.pem -out certificate.pem
```  
The below is the certificate.pem file which has the SSC certificate 
```shell
-----BEGIN CERTIFICATE-----
MIIDAzCCAesCFASjNXLgH93YMBQ9JDSbgEaamGM8MA0GCSqGSIb3DQEBCwUAMD4x
GDAWBgNVBAMMD3d3dy5kaXNjb3JkLmNvbTEiMCAGCSqGSIb3DQEJARYTY2FzaG9v
MjIyQGdtYWlsLmNvbTAeFw0yNDAzMTkxMjQyMDFaFw0yNTAzMTkxMjQyMDFaMD4x
GDAWBgNVBAMMD3d3dy5kaXNjb3JkLmNvbTEiMCAGCSqGSIb3DQEJARYTY2FzaG9v
MjIyQGdtYWlsLmNvbTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJdb
ZBzG9EEKg7zOW0I5K5rJy5MTFqrGos7jJB5DP3fgWiGoo4jMjemq0BrQs/iqbYCG
jwRJPyV6bqTpgxz93aqBO8guLM0WU1JkxMA8G4ddPFZdymc06S720imcoHeHcRXi
/HTeR4lAZZUEAneXaiwpfdPMZzZ5UNL8EWOnw6wwsnwKvSzgyqBAghADMCHetB5d
x8I+omJlMI6oV8AXbTrwMnAx+fS+BtVllgqi93YPz4a6dpV7dRgsXL6W1DRuVEfK
UIEOzsH64WZ5Cgvxi1il9bZRuImzcXe8jK1BSttf26LHsvsqHiF1FPqDTMMu66ky
aDUIdqyJs9r099g+CA0CAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAAQAstbH/CCCh
3nS7Fw8/+L1pzvQYNaSrqTQaFQU13vR9CHrPtEMVfNdonzPiyQJzClFKK5mJYItO
dD1xwZdvsJ1fKocrLml64QPoijQFy2BtuBRgTWC9IBGBRMQFeIlpFRb4xspgqn/p
aNj3Ia5C3diR5Ksmlz4PBcIpCONkbLZDLACsmR10gbCcyhpGpsrJ0nEOQJVhrPOQ
fiFCn6yvreNnB7pzfcMON7WolgLTJTRcBGwt/B5w0BPjXOlwZkDEAoNiW4/5+AWd
cggsnWpDiO0MZCrpbjVSmEo/YJKMy6RmSwUE5yNZeKpHwa3pUnAC/0QoyiLvU18Q
o4d8bin6ag==
-----END CERTIFICATE-----
```