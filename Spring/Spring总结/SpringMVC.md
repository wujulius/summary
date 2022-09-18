##  springMVC执行流程
https://blog.csdn.net/jimanglai/article/details/114331386?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166338307816781432952354%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=166338307816781432952354&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-114331386-null-null.142^v47^pc_rank_34_default_23,201^v3^control&utm_term=springMVC%E6%89%A7%E8%A1%8C%E6%B5%81%E7%A8%8B%E5%9B%BE&spm=1018.2226.3001.4187
    aftercompletion在渲染视图完毕与渲染结果返回客户端之前之间执行

## 多个Spring拦截器的执行流程
    springmvc的拦截器实现HandlerInterceptor接口后，会有三个抽象方法需要实现，分别为方法前执行preHandle，方法后postHandle，页面渲染后afterCompletion。

    1、当俩个拦截器都实现放行操作时，顺序为preHandle 1，preHandle 2，postHandle 2，postHandle 1，afterCompletion 2，afterCompletion 1

    2、当第一个拦截器preHandle返回false，也就是对其进行拦截时，第二个拦截器是完全不执行的，第一个拦截器只执行preHandle部分。

    3、当第一个拦截器preHandle返回true，第二个拦截器preHandle返回false，顺序为preHandle 1，preHandle 2 ，afterCompletion 1