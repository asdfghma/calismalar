#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void reverseWords(const char *inputText, const char *outputFilename) {
    FILE *outputFile;
    char word[100];
    int index = 0;
    
    outputFile = fopen(outputFilename, "w");
    if(outputFile == NULL) {
        printf("dosya %s oluþturulamadý\n", outputFilename);
        return;
    }
    
    for(int i = 0; i < strlen(inputText); i++) {
        char ch = inputText[i];
        if(ch != ' ' && ch != '\n' && ch!= '\0') {
            word[index++] = ch;
        } else {
            word[index] = '\0';
            int length = strlen(word);
            for(int j = length - 1 ; j >= 0; j--) {
                fprintf(outputFile, "%c", word[j]);
            }
            fprintf(outputFile, " ");
            index = 0;
        }
    }
    fclose(outputFile);
    
    printf("kelimeler baþarýyla tersine çevrilip %s dosyasýna yazdýrýldý\n", outputFilename);
}


int main()
{
    char inputText[1000];
char outputFilename[] = "output.txt";

printf("Giriþ metinini giriniz : ");
fgets(inputText, sizeof(inputText), stdin);
reverseWords(inputText, outputFilename);
    return 0;
}

