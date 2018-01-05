package mine.com.FourItems.ContentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by zhudongdong on 2018/1/5.
 */

public class ContentProviderCustom extends ContentProvider {

    private MyDatabaseHelper databaseHelper;
    @Override
    public boolean onCreate() {
        databaseHelper = new MyDatabaseHelper(getContext(), "contact.db", null,1);
        return true;
    }

    public static final String AUTHORITY = "com.jujin.mine";
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Uri uriReturn = null;

        switch (uriMatcher.match(uri)) {
            case CONTACT_Dir:
                long newContactId = db.insert("Contact", null, values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/contact/"+ newContactId);
                break;
            default:
                break;
        }
        return uriReturn;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {

        int deletRes = 0;
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)){
            case CONTACT_Item:
                deletRes = db.delete("Contact", selection, selectionArgs);
                break;
        }
        return deletRes;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String contactID = uri.getPathSegments().get(1);
        int updateRows = 0;
        switch (uriMatcher.match(uri)){
            case CONTACT_Item:
                updateRows = db.update("Contact", values, "id = ?", new String[]{contactID});
                break;
        }
        return updateRows;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri)){
            case CONTACT_Dir:
                cursor = database.query("Contact", projection, selection, selectionArgs, null,null, sortOrder);
                break;
            case CONTACT_Item:
                String contactId = uri.getPathSegments().get(1);
                cursor = database.query("Contact", projection, "id = ?", new String[]{contactId},
                        null, null, sortOrder);
                break;
        }
        return cursor;
    }


    private static UriMatcher uriMatcher;

    public static final int CONTACT_Item = 0;
    public static final int CONTACT_Dir = 1;
    static {
        uriMatcher= new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "contact", CONTACT_Dir);
        uriMatcher.addURI(AUTHORITY, "contact/#", CONTACT_Item);
    }
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

        String urlStr = null;
        switch (uriMatcher.match(uri)){
            case CONTACT_Item:
                urlStr = "vnd.android.cursor.item/vnd.com.jujin.mine.contact";
                break;
            case CONTACT_Dir:
                urlStr = "vnd.android.cursor.dir/vnd.com.jujin.mine.contact";
                break;
            default:
                break;
        }
        return urlStr;
    }
}
