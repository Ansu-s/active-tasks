## HTTPS Communication Flow   

TLS/SSL is a protocol used to secure communication over a computer network.
- Handshake: The TLS handshake is the first step in establishing a secure connection. 
- ClientHello: The client (e.g., a web browser) sends a message containing the supported cryptographic algorithms and other parameters.
- ServerHello: The server (e.g., a web server) responds with its chosen cryptographic algorithms and other parameters.
- Key Exchange: The client and server agree on a shared secret key to be used for encryption and decryption. This can involve asymmetric encryption (such as RSA) or key agreement protocols (such as Diffie-Hellman).
- Authentication: The server may request the client to authenticate itself using a digital certificate. This ensures that the client is communicating with the intended server and not an imposter.
- Server Authentication: The client verifies the server's digital certificate to ensure its authenticity.
- Encryption: Once the handshake is complete, the client and server use the agreed-upon cryptographic algorithms and the shared secret key to encrypt and decrypt data sent between them. This ensures that even if intercepted, the data cannot be understood by unauthorized parties.
- Data Transfer: With the secure connection established, the client and server can now exchange data securely. All data transmitted between them is encrypted and decrypted using the shared secret key.
- Session Management: TLS/SSL can also support session resumption, where a client and server can resume a previous session without re-negotiating parameters and performing a full handshake. This improves performance by reducing the overhead of establishing a secure connection for subsequent communications  

![Screenshot (80)](https://github.com/one-note/certificates/assets/130679461/45dcdb0a-e5a8-4d10-b647-fd6560611fd4)
![Screenshot (79)](https://github.com/one-note/certificates/assets/130679461/7009ddae-d3ff-41b2-8221-510d6e7872c0)
