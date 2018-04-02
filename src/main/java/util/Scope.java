package util;

/**
 * 用户授权接口权限值枚举类
 */
public enum Scope {

	auth_base("auth_base"), auth_user("auth_user");

	private String value;

	Scope(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
