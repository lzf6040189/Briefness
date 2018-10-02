package com.hacknife.briefness;

import com.hacknife.briefness.databinding.JavaLayout;
import com.hacknife.briefness.util.ClassUtil;
import com.hacknife.briefness.util.FileUtil;

import java.io.File;

import static com.hacknife.briefness.XmlInfo.SPLIT;
import static com.hacknife.briefness.XmlInfo.findMainModule;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : Briefness
 */

public class JavaInjector {
    public static final String PACKAGE_NAME = ClassUtil.findPackageName();
    public static final String PACKAGE = "// Generated by BriefnessProcessor (https://github.com/hacknife/Briefness).\n" +
            "// If you have any questions in use, please use email to contact me (e-mail:4884280@qq.com).\n" +
            "package com.hacknife.briefness;\n";
    public static final String IMPORT = "import android.graphics.Bitmap;\n" +
            "import android.util.Log;\n" +
            "import android.view.View;\n" +
            "import android.widget.Button;\n" +
            "import android.widget.EditText;\n" +
            "import android.widget.ImageView;\n" +
            "import android.widget.TextView;\n" +
            "import " + PACKAGE_NAME + ".briefness.ViewInjector;\n";

    public static final String CLASS = "public class BriefnessInjector {\n" +
            "    public static void injector(View view, Object value) {\n" +
            "        if (value == null | view == null) {\n" +
            "        } else if (ViewInjector.injector(view, value)) {\n" +
            "        } else if (view instanceof ImageView) {\n" +
            "            injectImageView((ImageView) view, value);\n" +
            "        } else if (view instanceof Button) {\n" +
            "            injectButton((Button) view, value);\n" +
            "        } else if (view instanceof EditText) {\n" +
            "            injectEditText((EditText) view, value);\n" +
            "        } else if (view instanceof TextView) {\n" +
            "            injectTextView((TextView) view, value);\n" +
            "        } else {\n" +
            "            Log.e(\"Briefness\", \"No match method and can not inject \" + view.getClass().getSimpleName());\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    private static void injectEditText(EditText view, Object value) {\n" +
            "        if (value instanceof String) {\n" +
            "            view.setText((String) value);\n" +
            "        } else if (value instanceof Integer) {\n" +
            "            view.setText((Integer) value);\n" +
            "        } else {\n" +
            "            Log.e(\"Briefness\", \"No match method and can not inject \" + view.getClass().getSimpleName());\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "    private static void injectButton(Button view, Object value) {\n" +
            "        if (value instanceof String) {\n" +
            "            view.setText((String) value);\n" +
            "        } else if (value instanceof Integer) {\n" +
            "            view.setText((Integer) value);\n" +
            "        } else {\n" +
            "            Log.e(\"Briefness\", \"No match method and can not inject \" + view.getClass().getSimpleName());\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    private static void injectImageView(ImageView view, Object value) {\n" +
            "        if (value instanceof Bitmap) {\n" +
            "            view.setImageBitmap((Bitmap) value);\n" +
            "        } else if (value instanceof Integer) {\n" +
            "            view.setImageResource((Integer) value);\n" +
            "        } else {\n" +
            "            Log.e(\"Briefness\", \"No match method and can not inject \" + view.getClass().getSimpleName());\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    private static void injectTextView(TextView view, Object value) {\n" +
            "        if (value instanceof String) {\n" +
            "            view.setText((String) value);\n" +
            "        } else if (value instanceof Integer) {\n" +
            "            view.setText((Integer) value);\n" +
            "        } else {\n" +
            "            Log.e(\"Briefness\", \"No match method and can not inject \" + view.getClass().getSimpleName());\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "}\n";

    public static final String BRIEFNESS_INJECTOR = "// Generated by BriefnessProcessor (https://github.com/hacknife/Briefness).\n" +
            "// This class and method can not be confused and modified !!\n" +
            "package " + PACKAGE_NAME + ".briefness;\n" +
            "\n" +
            "import android.view.View;\n" +
            "\n" +
            "/**\n" +
            " * author  : Hacknife\n" +
            " * e-mail  : 4884280@qq.com\n" +
            " * github  : http://github.com/hacknife\n" +
            " * project : Briefness\n" +
            " */\n" +
            "public class ViewInjector {\n" +
            "    public static boolean injector(View view, Object value) {\n" +
            "        return false;\n" +
            "    }\n" +
            "}";
    boolean debug = false;

    public void witeCode() {

        String java =findMainModule()+ SPLIT
                + "src/main/java/"
                + PACKAGE_NAME.replace(".", "/")
                + "/briefness/ViewInjector.java";

        if (!new File(java).exists())
            FileUtil.createFile(java, BRIEFNESS_INJECTOR);
    }

//    public boolean isBriefnessInjectorExits() {
//        String module = readTextFile(System.getProperty("user.dir") + "/BriefnessConfig");
//
//        String java = System.getProperty("user.dir") + SPLIT + module.replace(" ", "").replace("/", "") + SPLIT
//                + "build/generated/source/apt/debug/"
//                + "com.hacknife.briefness".replace(".", "/")
//                + "/BriefnessInjector.java";
//        boolean flag;
//        if (new File(java).exists()) {
//            flag = true;
//        } else {
//            flag = false;
//        }
//        java = System.getProperty("user.dir") + SPLIT + module.replace(" ", "").replace("/", "") + SPLIT
//                + "build/generated/source/apt/release/"
//                + "com.hacknife.briefness".replace(".", "/")
//                + "/BriefnessInjector.java";
//        if (new File(java).exists()) {
//            flag = true | flag;
//        } else {
//            flag = false | flag;
//        }
//        return flag;
//    }

    public String getBriefnessInjectorCode() {
        StringBuilder builder = new StringBuilder();
        return builder.append(PACKAGE)
                .append(IMPORT)
                .append(JavaLayout.author)
                .append(CLASS).toString();
    }
}