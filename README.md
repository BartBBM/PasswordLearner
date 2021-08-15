# Password Learner
Learn your Passwords - offline and secure!

### Usage
Start the program in a shell by "java -jar .\target\PasswordLearner-1.0-SNAPSHOT.jar".  
Generate the project via maven with "mvn verify".  
Create a "HashedPW.txt" and start learning new Passwords.  
Create a "HashedPWBU.txt" so it can generate Backups.

### Technical Info
Filepattern will be: Number:Hint:Hash.  
Passwords are hashed with sha3 and salted with "asdfjklö".
