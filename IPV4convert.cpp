#include <stdio.h>
#include <time.h>

unsigned int convertToDecimal(const char*ip) {
    unsigned int octet1, octet2, octet3, octet4;
    unsigned int ip_decimal;
    
    sscanf(ip, "%u.%u.%u.%u", &octet1, &octet2, &octet3, &octet4);
    ip_decimal = (octet1 << 24) | (octet2 <<16) | (octet3 << 8) | octet4;
    
    return ip_decimal;
}

int main() {
    char ip[16];
    unsigned int ip_decimal;
    
    printf("Lutfen bir IPV4 adresi giriniz : ");
    scanf("%15s", ip);
    
    ip_decimal = convertToDecimal(ip);
    printf("IPV4 adresinin tam sayi karsiligi : %u", ip_decimal);
}
