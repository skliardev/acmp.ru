#include <iostream>
#include <cmath>
using namespace std;
 
int c,n,xt,yt,x[1000],y[1000];
double p;
 
bool f() {
    double mins=p+1;
    for(int i=0; i<n; i++) {
        double s=0;
        for(int j=0; j<n; j++) {
            int dx=x[i]-x[j], dy=y[i]-y[j];
            s+=sqrt(dx*dx+dy*dy);
            if (s>mins) break;
        }
        int dx=x[i]-xt, dy=y[i]-yt;
        s+=sqrt(dx*dx+dy*dy);
        mins = s<mins ? s : mins;
    }
    return c*mins<=p;
}
 
int main() {
    cin>>n>>c>>p;
    for(int i=0; i<n; i++) cin>>x[i]>>y[i];
    cin>>xt>>yt;
    bool r=f(); cout<<(r ? "YES" : "NO");
}