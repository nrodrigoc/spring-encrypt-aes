## Encrypt and Decrypt using Spring with AES Algorithm
Simple API Encrypting and decrypting in Spring using the AES algorithm, that has a 32 bytes symmetric key to do this.

### How it works?

You need to pass some value as a param in the encrypt path, then it will return a json with the resulting string.

##### Obs.: 
To decrypt, you should encode the result in https://www.urlencoder.org/ (or some other url encoder), copy it and paste in the decrypt path's "value" param.
