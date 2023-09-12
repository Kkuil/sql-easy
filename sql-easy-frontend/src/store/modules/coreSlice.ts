import {createSlice} from "@reduxjs/toolkit"
import {TDataGenerateResult} from "@/types/core"

interface CoreState {
	data: TDataGenerateResult
}

const initialState: CoreState = {
	data: {
		createTableSql: "",
		insertSql: "",
		jsonCode: "",
		javaCode: "",
		typescriptCode: "",
		excel: "",
	},
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