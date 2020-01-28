package helper;

public enum Query {
    showAllAvto("select a.id,d.description,m.des,a.volume,a.year,a.cost  from passport.avtotest a\n" +
            " inner join passport.des d on d.id=a.marka \n" +
            " inner join passport.model m on m.id = a.model "),
    getAllUsers("select id,name,surname,email,username,password from passport.users"),
    addUser("insert into passport.users (id,name,surname,email,username,password) values (passport.seq_user.nextval,?,?,?,?,?)"),
    addAvto("insert into passport.avtotest (id,marka,model,volume,year,cost,userid) values (passport.seq_user.nextval,?,?,?,?,?,?)"),
    getModelsForMarka("select id,des from passport.model where type =?"),
    getMyAvtos("select a.id,d.description,m.des,a.volume,a.year,a.cost  from passport.avtotest a\n" +
            " inner join passport.des d on d.id=a.marka \n" +
            " inner join passport.model m on m.id = a.model  where userid=?"),
    getAvtoForId("select a.id,d.description,m.des,a.volume,a.year,a.cost  from passport.avtotest a\n" +
            " inner join passport.des d on d.id=a.marka \n" +
            " inner join passport.model m on m.id = a.model where a.id=?"),
    getImageForUserId("select id,des,avtoid from passport.images where avtoid=?"),
    uploadImageForAvtoId("insert into passport.images values (passport.seq_user.nextval,?,?)");
    String sql;

    Query(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
