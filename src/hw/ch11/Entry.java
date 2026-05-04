package hw.ch11;

import java.util.List;

public abstract class Entry {
    private Entry parent;

    // 이름을 얻는다
    public abstract String getName();

    // 크기를 얻는다
    public abstract int getSize();

    // 검색 기능
    public abstract List<Entry> search(String keyword);

    // 부모를 설정한다
    protected void setParent(Entry parent) {
        this.parent = parent;
    }

    // 부모를 얻는다
    public Entry getParent() {
        return parent;
    }

    // 전체 경로를 얻는다
    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        Entry entry = this;

        while (entry != null) {
            fullName.insert(0, "/" + entry.getName());
            entry = entry.getParent();
        }

        return fullName.toString();
    }

    // 목록을 표시한다
    public void printList() {
        printList("");
    }

    // prefix를 앞에 붙여서 목록을 표시한다
    protected abstract void printList(String prefix);

    // 문자열 표시
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}