#include <iostream>

using namespace std;

int main()
{
	int i;
	char c;
	char arr[] = "Hello, World";		//코테에서는 string 컨테이너 사용 금지 하기도 함
	string str;							//std::string 이라는 객체도 있음

	cout << 123 + 4 << " " 
		<< sizeof(123 + 4) 
		<< endl;						//이렇게 한 줄로 나눠서도 쓸 수 있음

	//1
	cout << endl;						//줄 바꿈 endl

	//2
	c = 'a';
	cout << c << " " << endl;

	//3
	cout << arr << endl;				//char arr[] = "Hello, World";

	//4
	str = "string str;";
	cout << str << endl;				//string str = "string str;";

	return 0;
}