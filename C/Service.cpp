#include<iostream>
#include<unistd.h>
#include<sys/socket.h>
#include<arpa/inet.h>
#include<string.h>
#include<errno.h>
#define SERV_PORT 8888
#define SERV_IP "127.1.1.1"

using namespace std;
int main(int argc,char **argv){
        int servfd,clitfd;
        struct sockaddr_in serv_addr,clit_addr;
        memset(&serv_addr,0,sizeof(clit_addr));
        memset(&clit_addr,0,sizeof(clit_addr));

        if((servfd=socket(AF_INET,SOCK_STREAM,0))==-1){
                cout<<"creat socket fail:"<<strerror(errno)<<endl;
                return 0;
        }
        serv_addr.sin_family=AF_INET;
        serv_addr.sin_port = htons(SERV_PORT);
        serv_addr.sin_addr.s_addr=inet_addr(SERV_IP);
        if(bind(servfd,(sockaddr *)& serv_addr,sizeof(serv_addr)) == -1){

                cout<<"bind failed : "<<strerror(errno)<<endl;
                return 0;
        }
        if(listen(servfd,1024)==-1){
                cout<<"listen failed:"<<strerror(errno)<<endl;
                return 0;

        }
        cout<<"Init Success!"<<endl;
        cout<<"ip:"<<inet_ntoa(serv_addr.sin_addr)<<"port:"<<ntohs(serv_addr.sin_port)<<endl;
        cout<<"Waiting for connecting"<<endl;

        socklen_t clit_size=0;
        if((clitfd=accept(servfd,(sockaddr*)&clit_addr,&clit_size))==-1)
        {
                cout<<"accept failed:"<<strerror(errno)<<endl;
                return 0;
        }
        cout<<"Client access:"<<inet_ntoa(clit_addr.sin_addr)<<" "<<ntohs(clit_addr.sin_port)<<endl;
        char buf[1024];
        while(1){
                int rdstate;
                if((rdstate=read(clitfd,buf,sizeof(buf)))>0){


                        int i=0;
                        cout<<"Server ercv :";
                        char buffer[rdstate+1];
                        for(i=0;i<rdstate;i++)
                                cout<<buf[i];
                                buffer[i]=buf[i];

                        }
                        buffer[i]='\0';
                        cout<<"\n文件接收成功 "<<buffer<<endl;

                        char rd_file[1024];

                        FILE *files=fopen(buffer,"r");
                        FILE *out=fopen("new.txt","w");
                        int len;

                        while((len=fread(rd_file,1,1024,files))>1){

                                fwrite(rd_file,1,len,out);
                        }
                        fflush(out);
                        fclose(files);
                        cout<<"文件拷贝成功"<<endl;



                }
                else if(rdstate==0){
                cout<<"client exit!"<<endl;
                return 0;
                }
        }

        close(servfd);
        close(clitfd);
        return 0;
}