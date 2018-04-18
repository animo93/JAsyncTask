package com.animo.JAsync;

import java.util.concurrent.Callable;


/**
 * @author animo
 *
 * @param <Params>
 * @param <Result>
 */
public class AsyncCallable<Params,Result> implements Callable<Result>{
	
	private Params params;
	private JAsyncTask<Params, Result> jAsyncTask;
	
	public AsyncCallable(Params params,JAsyncTask<Params, Result> jAsyncTask) {
		this.params = params;
		this.jAsyncTask = jAsyncTask;
	}

	@Override
	public Result call() throws Exception {
		Result result=null;
		Exception exception = null;
		try{
			result = jAsyncTask.runInBackground(params);
		}catch(Exception e){
			exception =e;
		}	
		jAsyncTask.postExecute(result,exception);
		return result;
	}

}

