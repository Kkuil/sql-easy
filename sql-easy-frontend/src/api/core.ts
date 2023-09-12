import request from "@/utils/request.ts"
import {TDataGenerateConfigInfo, TDataGenerateResult} from "@/types/core"
import {TResult} from "@/types/type"

/**
 * 生成数据接口
 * @param config 生成数据配置
 */
export const generate = (config: TDataGenerateConfigInfo): Promise<TResult<TDataGenerateResult>> => {
	return request({
		url: "/generate",
		method: "POST",
		data: config
	})
}