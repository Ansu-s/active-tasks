openssl genrsa -out key-pair.pem 2048

openssl rsa -in key-pair.pem -pubout -out public-key.pem

openssl req -new -key key-pair.pem -out certificate.csr

openssl x509 -req -days 365 -in certificate.csr -signkey key-pair.pem -out certificate.pem

