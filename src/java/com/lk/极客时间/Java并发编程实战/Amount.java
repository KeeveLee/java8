package com.lk.极客时间.Java并发编程实战;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-05-01 19:06
 */

class Account {
    private int balance;
    // 转账
    void transfer(Account target, int amt){
        // 锁转出账户
        synchronized(this){
            // 锁转入账户
            synchronized(target){
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }

//    /**
//     * 砍价
//     */
//    @RequestMapping("bargain.json")
//    public ApiResult bargain(@Valid @RequestBody BargainRequest request) {
//        Stopwatch stopwatch = Stopwatch.createStarted();
//
//        Response bargainResponse = process(request);
//
//        return ApiResult.success(bargainResponse);
//    }
//    private Response process(BargainRequest request){
//        try{
//            // 0 参数校验
//            // 1 风控校验
//            // 2 判断是否已经帮砍价
//            // 3 获取分布式锁
//            // 4 砍价
//            // 4.1 活动过规则校验
//            // 4.2 执行砍价并返回对应文案
//        }catch (Exception e){
//            // 5释放分布式锁
//        }
//        return new Response(false, "系统异常");
//    }

}