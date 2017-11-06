package ie.app.william.thewarganiser;

import android.os.Bundle;



/**
 * Created by William on 05/11/2017.
 */

public class Units {

    private int _id;
    private String _name;
    private String _classy;

    public Units(String name,String classy) {
        this._name = name;
        this._classy = classy;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_classy(String _classy) {
        this._classy = _classy;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public String get_classification() {
        return _classy;
    }
}
