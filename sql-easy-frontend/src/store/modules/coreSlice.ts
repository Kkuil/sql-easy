import {createSlice} from "@reduxjs/toolkit"
import {TDataGenerateResult} from "@/types/core"

interface CoreState {
	data: TDataGenerateResult
}

const initialState: CoreState = {
	data: {
		createTableSql: "-- test\n" +
			"CREATE TABLE IF NOT EXISTS test.`test` (\n" +
			"    test0 test DEFAULT test  NOT NULL UNIQUE PRIMARY KEY ON UPDATE CURRENT_TIMESTAMP COMMENT test,\n" +
			"    test1 test DEFAULT test  NOT NULL UNIQUE PRIMARY KEY ON UPDATE CURRENT_TIMESTAMP COMMENT test,\n" +
			"    test2 test DEFAULT test  NOT NULL UNIQUE PRIMARY KEY ON UPDATE CURRENT_TIMESTAMP COMMENT test,\n" +
			"    test3 test DEFAULT test  NOT NULL UNIQUE PRIMARY KEY ON UPDATE CURRENT_TIMESTAMP COMMENT test,\n" +
			"    test4 test DEFAULT test  NOT NULL UNIQUE PRIMARY KEY ON UPDATE CURRENT_TIMESTAMP COMMENT test,\n" +
			"    test5 test DEFAULT test  NOT NULL UNIQUE PRIMARY KEY ON UPDATE CURRENT_TIMESTAMP COMMENT test,\n" +
			"    test6 test DEFAULT test  NOT NULL UNIQUE PRIMARY KEY ON UPDATE CURRENT_TIMESTAMP COMMENT test,\n" +
			"    test7 test DEFAULT test  NOT NULL UNIQUE PRIMARY KEY ON UPDATE CURRENT_TIMESTAMP COMMENT test,\n" +
			"    test8 test DEFAULT test  NOT NULL UNIQUE PRIMARY KEY ON UPDATE CURRENT_TIMESTAMP COMMENT test,\n" +
			"    test9 test DEFAULT test  NOT NULL UNIQUE PRIMARY KEY ON UPDATE CURRENT_TIMESTAMP COMMENT test,\n" +
			"\n" +
			") ENGINE=test COMMENT=test;",
		insertSql: "INSERT INTO test.`test` (test0,test1,test2,test3,test4,test5,test6,test7,test8,test9) VALUES\n" +
			"(天津,1694442706830,http://www.ajo.cn,237.167.63.143,651034953@msn.com,王五,16758380816,台湾,天津,北京),\n" +
			"(天津,1694442706831,http://www.bbdv.org,50.96.153.224,984021511@yeah.net,张坝,13110552520,湖南,上海,深圳),\n" +
			"(深圳,1694442706832,http://www.bs.edu,97.11.143.48,638418590@etang.com,邓紫棋,16768122463,湖南,香港,江西),\n" +
			"(上海,1694442706833,https://www.haasi.edu,151.64.194.229,472232636@263.net,温暖,16248777488,香港,上海,天津),\n" +
			"(台湾,1694442706834,https://www.wbmdtcy.edu,110.116.216.53,463889141@sohu.com,张三,15538871680,江西,台湾,广州),\n" +
			"(重庆,1694442706835,http://www.pkv.abc,186.87.94.84,490776328@56.com,张三,14660756306,江西,台湾,上海),\n" +
			"(湖北,1694442706836,https://www.dcsd.site,49.155.13.234,508369803@googlemail.com,邓紫棋,18650724611,西藏,重庆,香港),\n" +
			"(上海,1694442706837,http://www..vip,203.89.197.113,211621993@163.com,李四,18347360828,天津,香港,香港),\n" +
			"(北京,1694442706838,http://www.gotghw.gov,19.199.55.230,608150563@mail.com,李四,14582485817,西藏,江西,广州),\n" +
			"(北京,1694442706839,http://www.sjdsmnl.com,41.249.191.177,635441279@gmail.com,李四,18871566731,湖南,上海,深圳),\n" +
			"(江西,1694442706840,http://www.wtld.love,19.236.70.72,313399154@gmail.com,老刘,18525804558,湖北,西藏,湖南),\n" +
			"(西藏,1694442706841,http://www.rdaxazy.cn,101.64.21.45,982932219@163.com,老刘,14668388107,深圳,西双版纳,深圳),\n" +
			"(江西,1694442706842,https://www.w.abc,90.169.9.113,899442030@163.com,李四,15136741734,北京,西藏,上海),\n" +
			"(香港,1694442706843,http://www.vbgph.gov,193.231.36.228,457119902@yahoo.com,李四,17047865685,重庆,西双版纳,杭州),\n" +
			"(天津,1694442706844,http://www.lwjooyh.love,248.86.181.205,309972964@56.com,周杰伦,13057608616,西藏,天津,重庆),\n" +
			"(西藏,1694442706845,https://www.nydgou.abc,126.126.115.247,295873132@qq.com,张坝,14831662812,香港,上海,重庆),\n" +
			"(深圳,1694442706846,http://www.t.com,214.124.122.243,66826995@sohu.com,老刘,14554073677,重庆,香港,湖南),\n" +
			"(北京,1694442706847,https://www.thfjvc.edu,85.226.118.85,737777772@walla.com,王琦,14365468472,重庆,重庆,北京),\n" +
			"(西藏,1694442706848,http://www.p.site,208.128.124.21,407383625@126.com,温暖,13464818800,深圳,西藏,上海),\n" +
			"(台湾,1694442706849,http://www.cvt.gov,150.37.61.240,295764561@126.com,周杰伦,16275747248,江西,西藏,重庆);",
		jsonCode: "[\n" +
			"  {\n" +
			"    \"test4\": \"651034953@msn.com\",\n" +
			"    \"test5\": \"王五\",\n" +
			"    \"test2\": \"http://www.ajo.cn\",\n" +
			"    \"test3\": \"237.167.63.143\",\n" +
			"    \"test8\": \"天津\",\n" +
			"    \"test9\": \"北京\",\n" +
			"    \"test6\": \"16758380816\",\n" +
			"    \"test7\": \"台湾\",\n" +
			"    \"test0\": \"天津\",\n" +
			"    \"test1\": \"1694442706830\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"984021511@yeah.net\",\n" +
			"    \"test5\": \"张坝\",\n" +
			"    \"test2\": \"http://www.bbdv.org\",\n" +
			"    \"test3\": \"50.96.153.224\",\n" +
			"    \"test8\": \"上海\",\n" +
			"    \"test9\": \"深圳\",\n" +
			"    \"test6\": \"13110552520\",\n" +
			"    \"test7\": \"湖南\",\n" +
			"    \"test0\": \"天津\",\n" +
			"    \"test1\": \"1694442706831\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"638418590@etang.com\",\n" +
			"    \"test5\": \"邓紫棋\",\n" +
			"    \"test2\": \"http://www.bs.edu\",\n" +
			"    \"test3\": \"97.11.143.48\",\n" +
			"    \"test8\": \"香港\",\n" +
			"    \"test9\": \"江西\",\n" +
			"    \"test6\": \"16768122463\",\n" +
			"    \"test7\": \"湖南\",\n" +
			"    \"test0\": \"深圳\",\n" +
			"    \"test1\": \"1694442706832\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"472232636@263.net\",\n" +
			"    \"test5\": \"温暖\",\n" +
			"    \"test2\": \"https://www.haasi.edu\",\n" +
			"    \"test3\": \"151.64.194.229\",\n" +
			"    \"test8\": \"上海\",\n" +
			"    \"test9\": \"天津\",\n" +
			"    \"test6\": \"16248777488\",\n" +
			"    \"test7\": \"香港\",\n" +
			"    \"test0\": \"上海\",\n" +
			"    \"test1\": \"1694442706833\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"463889141@sohu.com\",\n" +
			"    \"test5\": \"张三\",\n" +
			"    \"test2\": \"https://www.wbmdtcy.edu\",\n" +
			"    \"test3\": \"110.116.216.53\",\n" +
			"    \"test8\": \"台湾\",\n" +
			"    \"test9\": \"广州\",\n" +
			"    \"test6\": \"15538871680\",\n" +
			"    \"test7\": \"江西\",\n" +
			"    \"test0\": \"台湾\",\n" +
			"    \"test1\": \"1694442706834\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"490776328@56.com\",\n" +
			"    \"test5\": \"张三\",\n" +
			"    \"test2\": \"http://www.pkv.abc\",\n" +
			"    \"test3\": \"186.87.94.84\",\n" +
			"    \"test8\": \"台湾\",\n" +
			"    \"test9\": \"上海\",\n" +
			"    \"test6\": \"14660756306\",\n" +
			"    \"test7\": \"江西\",\n" +
			"    \"test0\": \"重庆\",\n" +
			"    \"test1\": \"1694442706835\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"508369803@googlemail.com\",\n" +
			"    \"test5\": \"邓紫棋\",\n" +
			"    \"test2\": \"https://www.dcsd.site\",\n" +
			"    \"test3\": \"49.155.13.234\",\n" +
			"    \"test8\": \"重庆\",\n" +
			"    \"test9\": \"香港\",\n" +
			"    \"test6\": \"18650724611\",\n" +
			"    \"test7\": \"西藏\",\n" +
			"    \"test0\": \"湖北\",\n" +
			"    \"test1\": \"1694442706836\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"211621993@163.com\",\n" +
			"    \"test5\": \"李四\",\n" +
			"    \"test2\": \"http://www..vip\",\n" +
			"    \"test3\": \"203.89.197.113\",\n" +
			"    \"test8\": \"香港\",\n" +
			"    \"test9\": \"香港\",\n" +
			"    \"test6\": \"18347360828\",\n" +
			"    \"test7\": \"天津\",\n" +
			"    \"test0\": \"上海\",\n" +
			"    \"test1\": \"1694442706837\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"608150563@mail.com\",\n" +
			"    \"test5\": \"李四\",\n" +
			"    \"test2\": \"http://www.gotghw.gov\",\n" +
			"    \"test3\": \"19.199.55.230\",\n" +
			"    \"test8\": \"江西\",\n" +
			"    \"test9\": \"广州\",\n" +
			"    \"test6\": \"14582485817\",\n" +
			"    \"test7\": \"西藏\",\n" +
			"    \"test0\": \"北京\",\n" +
			"    \"test1\": \"1694442706838\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"635441279@gmail.com\",\n" +
			"    \"test5\": \"李四\",\n" +
			"    \"test2\": \"http://www.sjdsmnl.com\",\n" +
			"    \"test3\": \"41.249.191.177\",\n" +
			"    \"test8\": \"上海\",\n" +
			"    \"test9\": \"深圳\",\n" +
			"    \"test6\": \"18871566731\",\n" +
			"    \"test7\": \"湖南\",\n" +
			"    \"test0\": \"北京\",\n" +
			"    \"test1\": \"1694442706839\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"313399154@gmail.com\",\n" +
			"    \"test5\": \"老刘\",\n" +
			"    \"test2\": \"http://www.wtld.love\",\n" +
			"    \"test3\": \"19.236.70.72\",\n" +
			"    \"test8\": \"西藏\",\n" +
			"    \"test9\": \"湖南\",\n" +
			"    \"test6\": \"18525804558\",\n" +
			"    \"test7\": \"湖北\",\n" +
			"    \"test0\": \"江西\",\n" +
			"    \"test1\": \"1694442706840\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"982932219@163.com\",\n" +
			"    \"test5\": \"老刘\",\n" +
			"    \"test2\": \"http://www.rdaxazy.cn\",\n" +
			"    \"test3\": \"101.64.21.45\",\n" +
			"    \"test8\": \"西双版纳\",\n" +
			"    \"test9\": \"深圳\",\n" +
			"    \"test6\": \"14668388107\",\n" +
			"    \"test7\": \"深圳\",\n" +
			"    \"test0\": \"西藏\",\n" +
			"    \"test1\": \"1694442706841\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"899442030@163.com\",\n" +
			"    \"test5\": \"李四\",\n" +
			"    \"test2\": \"https://www.w.abc\",\n" +
			"    \"test3\": \"90.169.9.113\",\n" +
			"    \"test8\": \"西藏\",\n" +
			"    \"test9\": \"上海\",\n" +
			"    \"test6\": \"15136741734\",\n" +
			"    \"test7\": \"北京\",\n" +
			"    \"test0\": \"江西\",\n" +
			"    \"test1\": \"1694442706842\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"457119902@yahoo.com\",\n" +
			"    \"test5\": \"李四\",\n" +
			"    \"test2\": \"http://www.vbgph.gov\",\n" +
			"    \"test3\": \"193.231.36.228\",\n" +
			"    \"test8\": \"西双版纳\",\n" +
			"    \"test9\": \"杭州\",\n" +
			"    \"test6\": \"17047865685\",\n" +
			"    \"test7\": \"重庆\",\n" +
			"    \"test0\": \"香港\",\n" +
			"    \"test1\": \"1694442706843\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"309972964@56.com\",\n" +
			"    \"test5\": \"周杰伦\",\n" +
			"    \"test2\": \"http://www.lwjooyh.love\",\n" +
			"    \"test3\": \"248.86.181.205\",\n" +
			"    \"test8\": \"天津\",\n" +
			"    \"test9\": \"重庆\",\n" +
			"    \"test6\": \"13057608616\",\n" +
			"    \"test7\": \"西藏\",\n" +
			"    \"test0\": \"天津\",\n" +
			"    \"test1\": \"1694442706844\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"295873132@qq.com\",\n" +
			"    \"test5\": \"张坝\",\n" +
			"    \"test2\": \"https://www.nydgou.abc\",\n" +
			"    \"test3\": \"126.126.115.247\",\n" +
			"    \"test8\": \"上海\",\n" +
			"    \"test9\": \"重庆\",\n" +
			"    \"test6\": \"14831662812\",\n" +
			"    \"test7\": \"香港\",\n" +
			"    \"test0\": \"西藏\",\n" +
			"    \"test1\": \"1694442706845\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"66826995@sohu.com\",\n" +
			"    \"test5\": \"老刘\",\n" +
			"    \"test2\": \"http://www.t.com\",\n" +
			"    \"test3\": \"214.124.122.243\",\n" +
			"    \"test8\": \"香港\",\n" +
			"    \"test9\": \"湖南\",\n" +
			"    \"test6\": \"14554073677\",\n" +
			"    \"test7\": \"重庆\",\n" +
			"    \"test0\": \"深圳\",\n" +
			"    \"test1\": \"1694442706846\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"737777772@walla.com\",\n" +
			"    \"test5\": \"王琦\",\n" +
			"    \"test2\": \"https://www.thfjvc.edu\",\n" +
			"    \"test3\": \"85.226.118.85\",\n" +
			"    \"test8\": \"重庆\",\n" +
			"    \"test9\": \"北京\",\n" +
			"    \"test6\": \"14365468472\",\n" +
			"    \"test7\": \"重庆\",\n" +
			"    \"test0\": \"北京\",\n" +
			"    \"test1\": \"1694442706847\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"407383625@126.com\",\n" +
			"    \"test5\": \"温暖\",\n" +
			"    \"test2\": \"http://www.p.site\",\n" +
			"    \"test3\": \"208.128.124.21\",\n" +
			"    \"test8\": \"西藏\",\n" +
			"    \"test9\": \"上海\",\n" +
			"    \"test6\": \"13464818800\",\n" +
			"    \"test7\": \"深圳\",\n" +
			"    \"test0\": \"西藏\",\n" +
			"    \"test1\": \"1694442706848\"\n" +
			"  },\n" +
			"  {\n" +
			"    \"test4\": \"295764561@126.com\",\n" +
			"    \"test5\": \"周杰伦\",\n" +
			"    \"test2\": \"http://www.cvt.gov\",\n" +
			"    \"test3\": \"150.37.61.240\",\n" +
			"    \"test8\": \"西藏\",\n" +
			"    \"test9\": \"重庆\",\n" +
			"    \"test6\": \"16275747248\",\n" +
			"    \"test7\": \"江西\",\n" +
			"    \"test0\": \"台湾\",\n" +
			"    \"test1\": \"1694442706849\"\n" +
			"  }\n" +
			"]",
		javaCode: "import lombok.Data;\n" +
			"\n" +
			"/**\n" +
			"* test\n" +
			"*/\n" +
			"@Data\n" +
			"public class test implements Serializable {\n" +
			"\n" +
			"    @Serial\n" +
			"    @TableField(exist = false)\n" +
			"    private static final long serialVersionUID = 1L;\n" +
			"\n" +
			"    /**\n" +
			"    * test\n" +
			"    */\n" +
			"    @TableField(value = test0)\n" +
			"    private test test0;\n" +
			"\n" +
			"    /**\n" +
			"    * test\n" +
			"    */\n" +
			"    @TableField(value = test1)\n" +
			"    private test test1;\n" +
			"\n" +
			"    /**\n" +
			"    * test\n" +
			"    */\n" +
			"    @TableField(value = test2)\n" +
			"    private test test2;\n" +
			"\n" +
			"    /**\n" +
			"    * test\n" +
			"    */\n" +
			"    @TableField(value = test3)\n" +
			"    private test test3;\n" +
			"\n" +
			"    /**\n" +
			"    * test\n" +
			"    */\n" +
			"    @TableField(value = test4)\n" +
			"    private test test4;\n" +
			"\n" +
			"    /**\n" +
			"    * test\n" +
			"    */\n" +
			"    @TableField(value = test5)\n" +
			"    private test test5;\n" +
			"\n" +
			"    /**\n" +
			"    * test\n" +
			"    */\n" +
			"    @TableField(value = test6)\n" +
			"    private test test6;\n" +
			"\n" +
			"    /**\n" +
			"    * test\n" +
			"    */\n" +
			"    @TableField(value = test7)\n" +
			"    private test test7;\n" +
			"\n" +
			"    /**\n" +
			"    * test\n" +
			"    */\n" +
			"    @TableField(value = test8)\n" +
			"    private test test8;\n" +
			"\n" +
			"    /**\n" +
			"    * test\n" +
			"    */\n" +
			"    @TableField(value = test9)\n" +
			"    private test test9;\n" +
			"\n" +
			"}",
		typescriptCode: "/**\n" +
			"* test\n" +
			"*/\n" +
			"interface test {\n" +
			"    // test\n" +
			"    test0: string;\n" +
			"    // test\n" +
			"    test1: string;\n" +
			"    // test\n" +
			"    test2: string;\n" +
			"    // test\n" +
			"    test3: string;\n" +
			"    // test\n" +
			"    test4: string;\n" +
			"    // test\n" +
			"    test5: string;\n" +
			"    // test\n" +
			"    test6: string;\n" +
			"    // test\n" +
			"    test7: string;\n" +
			"    // test\n" +
			"    test8: string;\n" +
			"    // test\n" +
			"    test9: string;\n" +
			"}",
		excel: "https://sql-easy.oss-cn-hangzhou.aliyuncs.com/test-1694442707012.xlsx",
	}
}

export const coreSlice = createSlice({
	name: "core",
	initialState,
	reducers: {
		setData: (state, payload) => {
			state.data = payload.payload
		},
	},
})

export const {setData} = coreSlice.actions

export default coreSlice.reducer