import request from "@/utils/request"
import {TListResult, TResult} from "@/types/type"

/**
 * 获取模拟数据类型
 */
export const listMockType = (): Promise<TResult<TListResult[]>> => {
	return request({
		url: "/mock-strategy/list",
		method: "GET"
	})
}