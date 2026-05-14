/* Enter your macros here */
#define toStr(x)# x
#define io(v) cin >> v
#define INF 100000000
#define foreach(v, i) for (int i = 0; i < v.size(); i++)
#define FUNCTION(name, op) \
void name(int &a, int b)\
{                       \
    if (b op a) a = b;  \
}                        
