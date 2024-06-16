#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define XOR_KEY 0x0F

struct User {
char username[50];
char password[50];
};

void encryptFile(const char *filename, const struct User *user, unsigned char key );

void decryptFile(const char *filename,  struct User *user, unsigned char key);

int main() {
	struct User user;
	
	printf("Kullanici adi : ");
	scanf("%s", user.username);
	
	printf("Sifre : ");
	scanf("%s", user.password);
	
	encryptFile("users_encrypted.txt", &user, XOR_KEY);
	
	decryptFile("users_encrypted.txt", &user, XOR_KEY);
	
	
	return 0;
}


void encryptFile(const char *filename, const struct User *user, unsigned char key) {
	FILE *file = fopen(filename, "ab");
	
	if(!file) {
		perror("Dosya acma hatasi");
		exit(1);
	}
	
	for(size_t i = 0; i < strlen(user->username); ++i) {
		fputc(user->username[i] ^ key, file);
	}
	fputc('\n', file);
	for(size_t i = 0; i < strlen(user->password); ++i) {
		fputc(user->password[i] ^ key, file);
	}
	
	fclose(file);
	
	printf("Bilgiler '%s' dosyasina basariyla sifrelenerek kaydedildi \n", filename);
}

void decryptFile(const char *filename, struct User *user, unsigned char key) {
	FILE *file = fopen(filename, "rb");
	
	if(!file) {
		perror("Dosya acma hatasi");
		exit(1);
	}
	
	char ch;
	int index = 0;
	
	while((ch = fgetc(file)) != EOF) {
		if(ch == '\n') {
			index = 0;
			continue;
		}
		
		if(index < 50) {
			if( index < strlen(user->username)) {
				user->username[index] = ch ^ key;
			} else {
				user->password[index - strlen(user->username)] = ch ^ key;
			}
			index++;
		}
	}
	
	fclose(file);
}

