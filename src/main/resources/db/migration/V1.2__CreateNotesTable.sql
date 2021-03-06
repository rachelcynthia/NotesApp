CREATE TABLE NOTES (
    NOTE_ID INT GENERATED ALWAYS AS IDENTITY,
    EMAIL VARCHAR(255) NOT NULL,
    TITLE VARCHAR(50) NOT NULL,
    CONTENT TEXT NOT NULL,
    PRIMARY KEY(NOTE_ID),
    CONSTRAINT FK_USER
    FOREIGN KEY (EMAIL)
    REFERENCES AUTHENTICATION(EMAIL)
);