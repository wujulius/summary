# web层
    对浏览器中数据的封装
### 步骤一：
    Map<String,String[]> map = request.getParameterMap();
### 步骤二：
    创建javaBean对象
    Admin admin = new Admin();
### 步骤三：
    BeanUtils.poputation(admin,map);
# dao层：
    public int UpdateUserInfor(String username, String password) {
        String sql = "insert into tab_admin values(?,?,?)";
        int i = jdbcTemplate.update(sql,null,username,password);
        return  i;
    }