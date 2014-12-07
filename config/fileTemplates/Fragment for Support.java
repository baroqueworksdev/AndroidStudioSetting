#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "") package ${PACKAGE_NAME};#end

import android.support.v4.app.Fragment
import android.os.Bundle;

#parse("File Header.java")
public class ${NAME} extends Fragment {
    public static final String TAG = ${NAME}.class.getSimpleName();

    // Note: only the system can call this constructor by reflection. 
    public ${NAME}() {}

    public static ${NAME} getInstance() {
        ${NAME} fragment = new ${NAME}();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}