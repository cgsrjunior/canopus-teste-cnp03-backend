//CREATE TABLE FILEDATA(
//                         id INT AUTO INCREMENT PRIMARY KEY,
//                         name VARCHAR(250) NOT NULL,
//                         type VARCHAR(250) NOT NULL,
//                         byte BINARY VARING(1000) NOT NULL
//);


INSERT INTO FILEDATA (id, name, type, byte) VALUES (null, 'img1', 'jpg', FILE_READ('classpath:src/main/resources/images/picsum1.jpg'));
INSERT INTO FILEDATA (id, name, type, byte) VALUES (null, 'img2', 'jpg', FILE_READ('classpath:src/main/resources/images/picsum2.jpg'));
INSERT INTO FILEDATA (id, name, type, byte) VALUES (null, 'img3', 'jpg', FILE_READ('classpath:src/main/resources/images/picsum3.jpg'));

