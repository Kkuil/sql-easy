import request from "@/utils/request.ts"
import {TLogin, TRegistry} from "@/types/user"
import {TResult} from "@/types/type"

/**
 *  登录
 * @param loginInfo 登录信息
 */
export const login = (loginInfo: TLogin): Promise<TResult<string>> => {
	return request({
		url: "/login",
		method: "POST",
		data: {
			username: loginInfo.username,
			password: loginInfo.password,
		}
	})
}

/**
 *  注册
 * @param registryInfo 注册信息
 */
export const registry = (registryInfo: TRegistry): Promise<TResult<boolean>> => {
	return request({
		url: "/registry",
		method: "POST",
		data: {
			username: registryInfo.username,
			password: registryInfo.password,
		}
	})
}