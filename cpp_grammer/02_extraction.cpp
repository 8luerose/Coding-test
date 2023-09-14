#include <iostream>

using namespace std;

int main()
{
	//1
	char input[100];

	cin >> input;								//cin: 공백을 기준으로 입력
	cout << "1 " << input << endl;

	//2
	cin.ignore();								//한 문자만 짤라버림: ' 'world\n 중 ' '만 삭제
	// cin.ignore('\n', 100);					//줄바꿈 문자(\n)를 만날 때까지 무시  ' 'world\n 중 전체 삭제
	// + cin.ignore(numeric_limits<streamsize>::max(), '\n');	== numeric_limits<streamsize>::max() 최대 사이즈 무시하겠다

	//3
	string str;

	getline(cin, str);							//동적으로 할당, cin으로 받아서 str에 저장한다. \n 만날 때까지. std::getline 클래스 멤버 
	cout << "string str: " << str << endl;
	
	cin.getline(input, sizeof(input));			//정적으로 할당, cin.getline(변수, 길이) std::istream 클래스 멤버;
	cout << "cin.getline: " << input << endl;

	//4
	int i;
	int j;

	cin >> i;
	cin >> j;									//cin은 공백을 기준으로 입력되므로 1 5 입력 시 따로 들어감
	cout << "i: " << i << " j: " << j << endl;
	return 0;
}