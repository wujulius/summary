# Git使用

## git使用流程

### 本地仓库的创建

    安装git，创建相应的本地仓库，使用git init 进行初始化本地仓库
    
    配置 用户名 git config --global user.name "用户名" (中间有空格)

    配置 邮箱  git config --global user.email "邮箱号" 

    查看用户名 git config user.name

    查看配置列表 git cofig --list
### 远程仓库的创建

    使用命令在相应的目录生成公钥（一般在c盘对应管理员用户.ssh生成）
    命令：ssh-keygen -t rsa

    在对应的远程仓库中的ssh公钥中添加对应的公钥（irsa-pub）

### 将本地仓库上传到远程仓库

    本地仓库输入远程仓库对应的URL
    git remote add origin 对应仓库的URL

    添加命令：git add . (提交所有文件)
    
    提交命令：git commit -m “记录”

    推送命令：git push -u origin main

![git远程使用命令](\img\Snipaste_2022-09-28_17-37-45.png)
![git远程使用命令](\img\Snipaste_2022-09-28_17-37-56.png)

## 分支使用命令

    # 列出所有本地分支
    git branch
    # 列出所有远程分支
    git branch -r
    # 新建一个分支，但依然停留在当前分支
    git branch [branch-name]
    # 新建一个分支，并切换到该分支
    git checkout -b [branch]
    # 合并指定分支到当前分支$
    git merge [branch]
    # 删除分支$ 
    git branch -d [branch-name]
    # 删除远程分支$ 
    git push origin --delete [branch-name]$
    git branch -dr [remote/branch]




