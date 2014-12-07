
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import android.os.AsyncTask;

public class ${NAME} extends AsyncTask<Params, Progress, Result> {
    private ${NAME}Listener mListener;

    /**
     * UIスレッドへの通知用リスナー
     *
     * @note UIスレッド上で実行を行います
     */
    // TODO: rename interface class
    public interface ${NAME}Listener {
        /** タスク実行前 */
        public void onPreExecute();

        /** タスクの進捗状況を通知します */
        public void onProgressUpdate(int progress);

        /** タスク結果を渡します */
        public void onPostExecute(Result result);
    }

    public SampleAsyncTask(${NAME}Listener listener) {
        mListener = listener;
    }

    @Override
    protected Result doInBackground(Params... param) {
        return result;
    }

    @Override
    protected void onPreExecute() {
        mListener.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Progress... values) {
        mListener.onProgressUpdate(values[0]);
    }

    @Override
    protected void onPostExecute(Result result) {
        mListener.onPostExecute(result);
    }

}