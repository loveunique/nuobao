package com.nuobao.common.constant;

/**
 * 存放预定义错误码
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 12:16
 * @modify
 **/
public interface ApplicationErrorCode {

	/**
	 * 伪造交易数据
	 */
	String FAKE_TRAN_DATA="EX9999";

	/**
	 * 不能为空
	 */
	String NOT_NULL = "100000";
	
	/**
	 * 接口返回错误码或功能模块中定义的错误码
	 * {0}
	 */
	String USER_DEFINED_ERROR = "100100";
	
	/**
	 * 不允许重名
	 */
	String NOT_ALLOW_REPEAT = "100001";
	
	/**
	 * 对象不存在
	 */
	String CLASS_NOT_EXIST = "100002";
	
	/**
	 * 至少需要为操作员配置一个角色
	 */
	String AT_LEAST_ONE_ROLE = "200000" ;
	
	/** 
	 * 登录超时
	 */
	String LOGIN_TIMEOUT = "200001";
	
	/** 
	 * 无访问权限
	 */
	String ACCESS_NO_PERMISSION = "200002";
	
   /**
    * 密码随机数获取失败或已经超时
    */
	String PWDNUM_IS_ERROR = "300001";
	
	/**
	 * 密码错误
	 */
	String PWD_IS_ERROR ="300003";
	/**
	 * 用户创建失败,重复提交
	 */
	String USER_CREATE_REPEAT_FAIL = "400001";
	
	/**
	 * 用户创建失败,数据库连接失败
	 */
	String USER_CREATE_CONNECT_FAIL = "400002";
	
	/**
	 * 用户不存在
	 */
	String USER_IS_NOT_EXIT = "400003";
	
	/**
	 * 原密码输入错误，请确认后重新输入
	 */
	String ACCOUNT_PASSWORD_MISMATCH = "400004";
	
	/**
	 * 验证码不匹配，请重新输入
	 */
	String VERIFYCODE_NOT_MATCH = "400005";
	/**
	 * 短信验证码获取频繁,请稍后再获取
	 */
	String MESSAGE_IS_FREQUENT = "400006";
	/**
	 * 身份证已存在
	 */
	String CTFNO_IS_EXIST = "400007";
	/**
	 * 新密码两次输入的不一致,请重新输入
	 */
	String PASSWORD_NOT_EQUAL = "400008";
	/**
	 * 页面超时,请刷新重试
	 */
	String PWDREDIS_IS_ERROR = "400009";
	/**
	 * 密码转换失败
	 */
	String PWDDCRYPT_IS_ERROR = "400010";
	
	/**
	 * 报文域解析异常
	 */
	String RESOLVE_CONTENT_FAIL = "500001";
	
	/**
	 * 请求报文创建异常
	 */
	String REQUESTDATA_CREATE_FAIL = "500002";
	
	/**
	 * 解析报文异常
	 */
	String RESOLVE_HOST_FAIL = "500003";
	
	/**
	 * object--> JSON 解析异常
	 */
	String OBJECT_TO_JSON_FAIL = "500004";
	
	/**
	 * JSON--> object  解析异常
	 */
	String JSON_TO_OBJECT_FAIL = "500005";
	
	/**
	 * 缓存服务器异常
	 */
	String CACHE_ERROR = "999997";
	
	/**
	 * 系统异常
	 */
	String SYSTEM_WITHMESSAGE_ERROR = "999998";
	
	/**
	 * 系统异常
	 */
	String SYSTEM_ERROR = "999999";
	
	/**
	 * 核心通信异常
	 */
	String INTEGRATION_ERROR = "888887";
	
	/**
	 * 通信异常
	 */
	String HTTP_ERROR  ="888888";
	
	
	/**
	 * http通信异常
	 */
	String HOST_HTTP_ERROR="888889";
	
	/**
	 * 文件上传失败
	 */
	String FILE_UPLOAD_FAIL = "UB0001";
	
	/**
	 * 文件下载失败
	 */
	String FILE_DOWNLOAD_FAIL = "UB0002";
}
