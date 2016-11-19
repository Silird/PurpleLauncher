package tests.JsonClasses;

import java.util.List;

public class JsonClass {
    private String __comment;

    private LatestClass latest;

    private List<VersionClass> versions;

    public JsonClass() {

    }

    public String get__comment() {
        return __comment;
    }

    public void set__comment(String __comment) {
        this.__comment = __comment;
    }

    public LatestClass getLatest() {
        return latest;
    }

    public void setLatest(LatestClass latest) {
        this.latest = latest;
    }

    public List<VersionClass> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionClass> versions) {
        this.versions = versions;
    }
}
