package dbUtils;

import dbObjects.*;
import oracle.jdbc.OracleTypes;

import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class CallableStatementParameter {

    // This method return database connection object by using the configuration data in a properties file.
    public Connection getDBConnectionFromPropertiesFile() {
        Connection ret = null;

        try
        {
            // Create Properties object.
            Properties props = new Properties();

            File dbPropsFile = new File("src/main/resources/JDBCSettings.properties");

            FileReader fileReader = new FileReader(dbPropsFile);

            // Load jdbc related properties in above file.
            props.load(fileReader);

            // Get each property value.
            String dbDriverClass = props.getProperty("db.driver.class");

            String dbConnUrl = props.getProperty("db.conn.url");

            String dbUserName = props.getProperty("db.username");

            String dbPassword = props.getProperty("db.password");

            /* Register jdbc driver class. */
            Class.forName(dbDriverClass);

            // Get database connection object.
            ret = DriverManager.getConnection(dbConnUrl, dbUserName, dbPassword);

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }finally
        {
            return ret;
        }
    }






    //NAGRODY
    public String proceduraZapiszStadion(String nazwa, String miasto, String ulica, Integer numer, Integer pojemnosc) {
        String error = "";
        try {
            //p_nazwa IN VARCHAR, p_miasto IN VARCHAR, p_ulica IN VARCHAR, p_numer IN NUMBER, p_pojemnosc IN NUMBER, crit_error_message OUT VARCHAR2
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.stadion(?,?,?,?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, nazwa);
            cStmt.setString(2, miasto);
            cStmt.setString(3, ulica);
            cStmt.setInt(4, numer);
            cStmt.setInt(5, pojemnosc);
            cStmt.registerOutParameter(6, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(6);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<Stadion> widokStadionów() {
        List<Stadion> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select * from STADION";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nazwa = rs.getString("nazwa");
                String miasto = rs.getString("miasto");
                String ulica = rs.getString("ulica");
                Integer numer = rs.getInt("numer");
                Integer pojemnosc = rs.getInt("pojemnosc");
                arrayList.add(new Stadion(id,nazwa,miasto,ulica,numer,pojemnosc));
            }
        } catch (SQLException e ) {
            System.out.println("Coś się zjebało");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunStadion(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.STADION(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //NARODOWOSC
    public String proceduraZapiszNarodowosc(String nazwa) {
        String error = "";
        try {
            //p_nazwa IN VARCHAR, p_miasto IN VARCHAR, p_ulica IN VARCHAR, p_numer IN NUMBER, p_pojemnosc IN NUMBER, crit_error_message OUT VARCHAR2
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.narodowosc(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, nazwa);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<Narodowosc> widokNarodowosci() {
        List<Narodowosc> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select * from narodowosc";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nazwa = rs.getString("nazwa");
                arrayList.add(new Narodowosc(id,nazwa));
            }
        } catch (SQLException e ) {
            System.out.println("Coś się zjebało");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunNarodowosc(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.narodowosc(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //SEDZIA
    public String proceduraZapiszSedziego(String imie, String nazwisko, String licencja, Integer narodowosc) {
        String error = "";
        try {
            //p_nazwa IN VARCHAR, p_miasto IN VARCHAR, p_ulica IN VARCHAR, p_numer IN NUMBER, p_pojemnosc IN NUMBER, crit_error_message OUT VARCHAR2
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.sedziego(?,?,?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, imie);
            cStmt.setString(2, nazwisko);
            cStmt.setString(3, licencja);
            cStmt.setInt(4, narodowosc);
            cStmt.registerOutParameter(5, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(5);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<SedziaTrener> widokSedziow() {
        List<SedziaTrener> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select sedzia.id,imie,nazwisko,licencja,id_narodowosci, narodowosc.nazwa from sedzia join narodowosc on narodowosc.id = sedzia.id_narodowosci";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                String licencja = rs.getString("licencja");
                Integer narodowosc = rs.getInt("id_narodowosci");
                String nazwa = rs.getString("nazwa");
                arrayList.add(new SedziaTrener(id,imie,nazwisko,licencja,narodowosc,nazwa));
            }
        } catch (SQLException e ) {
            System.out.println("Coś się zjebało");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunSedziego(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.sedziego(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //TRENER
    public String proceduraZapiszTrenera(String imie, String nazwisko, String licencja, Integer narodowosc) {
        String error = "";
        try {
            //p_nazwa IN VARCHAR, p_miasto IN VARCHAR, p_ulica IN VARCHAR, p_numer IN NUMBER, p_pojemnosc IN NUMBER, crit_error_message OUT VARCHAR2
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.trenera(?,?,?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, imie);
            cStmt.setString(2, nazwisko);
            cStmt.setString(3, licencja);
            cStmt.setInt(4, narodowosc);
            cStmt.registerOutParameter(5, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(5);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<SedziaTrener> widokTrenerow() {
        List<SedziaTrener> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select trener.id,imie,nazwisko,licencja,id_narodowosci, narodowosc.nazwa from trener join narodowosc on narodowosc.id = trener.id_narodowosci";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                String licencja = rs.getString("licencja");
                Integer narodowosc = rs.getInt("id_narodowosci");
                String nazwa = rs.getString("nazwa");

                arrayList.add(new SedziaTrener(id,imie,nazwisko,licencja,narodowosc,nazwa));
            }
        } catch (SQLException e ) {
            System.out.println("Coś się zjebało widok trenerow");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunTrenerow(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.trenera(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //POZYCJA
    public String proceduraZapiszPozycje(String nazwa) {
        String error = "";
        try {
            //p_nazwa IN VARCHAR, p_miasto IN VARCHAR, p_ulica IN VARCHAR, p_numer IN NUMBER, p_pojemnosc IN NUMBER, crit_error_message OUT VARCHAR2
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.pozycje(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, nazwa);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<Pozycja> widokPozycji() {
        List<Pozycja> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select * from pozycja";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nazwa = rs.getString("nazwa");
                arrayList.add(new Pozycja(id,nazwa));
            }
        } catch (SQLException e ) {
            System.out.println("Coś się zjebało");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunPozycje(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.pozycje(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //KLUB
    public String proceduraZapiszKlub(String nazwa, String miasto, Integer id_stadionu, Integer id_trenera) {
        String error = "";
        try {
            //(p_nazwa IN VARCHAR, p_miasto IN VARCHAR, p_id_trenera IN NUMBER, p_id_stadionu IN NUMBER, crit_error_message OUT VARCHAR2);
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.klub(?,?,?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, nazwa);
            cStmt.setString(2, miasto);
            cStmt.setInt(3, id_trenera);
            cStmt.setInt(4, id_stadionu);
            cStmt.registerOutParameter(5, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(5);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<Klub> widokKlubow() {
        List<Klub> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select klub.id,klub.nazwa,klub.miasto,id_trenera,id_stadionu, stadion.nazwa AS nazwa_stadionu, trener.imie, trener.nazwisko from klub join trener on id_trenera = trener.id join stadion on id_stadionu = stadion.id";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nazwa = rs.getString("nazwa");
                String miasto = rs.getString("miasto");
                Integer id_trenera = rs.getInt("id_trenera");
                Integer id_stadionu = rs.getInt("id_stadionu");
                String nazwa_stadionu = rs.getString("nazwa_stadionu");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");

                arrayList.add(new Klub(id,nazwa,miasto,id_trenera,id_stadionu, imie+" "+nazwisko, nazwa_stadionu));
            }
        } catch (SQLException e ) {
            System.out.println("Coś się zjebało widok trenerow");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunKlub(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.klub(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //ZAWODNIK
    public String proceduraZapiszZawodnik(Integer p_id_klubu, String p_imie, String p_nazwisko, Integer p_id_pozycji, Integer p_pensja, Date p_data_ur, Integer p_wzrost, Integer p_id_narodowosci) {
        String error = "";
        try {
            //(p_id_klubu IN NUMBER, p_imie IN VARCHAR, p_nazwisko IN VARCHAR, p_id_pozycji IN NUMBER, p_pensja IN NUMBER,
            // p_data_ur IN DATE, p_wzrost IN NUMBER, p_id_narodowosci IN NUMBER, crit_error_message OUT VARCHAR2)
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.zawodnika(?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);
            cStmt.setInt(1, p_id_klubu);
            cStmt.setString(2, p_imie);
            cStmt.setString(3, p_nazwisko);
            cStmt.setInt(4, p_id_pozycji);
            cStmt.setInt(5, p_pensja);
            cStmt.setDate(6, (java.sql.Date) p_data_ur);
            cStmt.setInt(7, p_wzrost);
            cStmt.setInt(8, p_id_narodowosci);

            cStmt.registerOutParameter(9, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(9);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<Zawodnik> widokZawodnik() {
        List<Zawodnik> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select \n" +
                        "zawodnik.id,\n" +
                        "zawodnik.imie,\n" +
                        "zawodnik.nazwisko,\n" +
                        "zawodnik.pensja,\n" +
                        "zawodnik.dataurodzenia,\n" +
                        "zawodnik.wzrost,\n" +
                        "zawodnik.klub_id,\n" +
                        "zawodnik.pozycja_id,\n" +
                        "zawodnik.narodowosc_id,\n" +
                        "klub.nazwa AS nazwaklubu,\n" +
                        "pozycja.nazwa as nazwapozycji,\n" +
                        "narodowosc.nazwa as nazwanarodowosci\n" +
                        "from zawodnik\n" +
                        "join klub on zawodnik.klub_id = klub.id\n" +
                        "join pozycja on zawodnik.pozycja_id = pozycja.id\n" +
                        "join narodowosc on zawodnik.narodowosc_id = narodowosc.id";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                Integer pensja = rs.getInt("pensja");
                Date dataurodzenia = rs.getDate("dataurodzenia");
                Integer wzrost = rs.getInt("wzrost");
                Integer klub_id = rs.getInt("klub_id");
                Integer pozycja_id = rs.getInt("pozycja_id");
                Integer narodowosc_id = rs.getInt("narodowosc_id");
                String nazwaklubu = rs.getString("nazwaklubu");
                String nazwapozycji = rs.getString("nazwapozycji");
                String nazwanarodowosci = rs.getString("nazwanarodowosci");

                arrayList.add(new Zawodnik(id,imie,nazwisko,klub_id,pozycja_id,narodowosc_id, pensja, wzrost,dataurodzenia,nazwaklubu,nazwanarodowosci,nazwapozycji ));
            }
        } catch (SQLException e ) {
            System.out.println("Coś się zjebało widok trenerow");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public List<Zawodnik> widokZawodnikKonkretnyKlub(int id_klubu) {
        List<Zawodnik> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select \n" +
                        "zawodnik.id,\n" +
                        "zawodnik.imie,\n" +
                        "zawodnik.nazwisko,\n" +
                        "zawodnik.pensja,\n" +
                        "zawodnik.dataurodzenia,\n" +
                        "zawodnik.wzrost,\n" +
                        "zawodnik.klub_id,\n" +
                        "zawodnik.pozycja_id,\n" +
                        "zawodnik.narodowosc_id,\n" +
                        "klub.nazwa AS nazwaklubu,\n" +
                        "pozycja.nazwa as nazwapozycji,\n" +
                        "narodowosc.nazwa as nazwanarodowosci\n" +
                        "from zawodnik\n" +
                        "join klub on zawodnik.klub_id = klub.id\n" +
                        "join pozycja on zawodnik.pozycja_id = pozycja.id\n" +
                        "join narodowosc on zawodnik.narodowosc_id = narodowosc.id where zawodnik.klub_id="+id_klubu;

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                Integer pensja = rs.getInt("pensja");
                Date dataurodzenia = rs.getDate("dataurodzenia");
                Integer wzrost = rs.getInt("wzrost");
                Integer klub_id = rs.getInt("klub_id");
                Integer pozycja_id = rs.getInt("pozycja_id");
                Integer narodowosc_id = rs.getInt("narodowosc_id");
                String nazwaklubu = rs.getString("nazwaklubu");
                String nazwapozycji = rs.getString("nazwapozycji");
                String nazwanarodowosci = rs.getString("nazwanarodowosci");

                arrayList.add(new Zawodnik(id,imie,nazwisko,klub_id,pozycja_id,narodowosc_id, pensja, wzrost,dataurodzenia,nazwaklubu,nazwanarodowosci,nazwapozycji ));
            }
        } catch (SQLException e ) {
            System.out.println("Coś się zjebało widok trenerow");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunZawodnik(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.zawodnika(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //MECZ
    public String proceduraZapiszMecz(Integer p_stadion_id, Integer p_gospodarz_id, Integer p_gosc_id, Integer p_sedzia_id, Date p_data) {
        String error = "";
        try {
            //(p_stadion_id IN NUMBER, p_gospodarz_id IN NUMBER, p_gosc_id IN NUMBER, p_sedzia_id IN NUMBER, p_data IN DATE, crit_error_message OUT VARCHAR2);
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.mecz(?,?,?,?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);
            cStmt.setInt(1, p_stadion_id);
            cStmt.setInt(2, p_gospodarz_id);
            cStmt.setInt(3, p_gosc_id);
            cStmt.setInt(4, p_sedzia_id);
            cStmt.setDate(5, (java.sql.Date) p_data);

            cStmt.registerOutParameter(6, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(6);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<Mecz> widokMeczow() {
        List<Mecz> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select \n" +
                        "mecz.id,\n" +
                        "mecz.stadion_id,\n" +
                        "mecz.gospodarz_id,\n" +
                        "mecz.gosc_id,\n" +
                        "mecz.wynik_id,\n" +
                        "mecz.sedzia_id,\n" +
                        "mecz.frekwencja,\n" +
                        "mecz.dataspotkania,\n" +
                        "stadion.nazwa AS nazwastadionu,\n" +
                        "A.nazwa AS gospodarznazwa,\n" +
                        "B.nazwa AS goscnazwa,\n" +
                        "wynik.gole_gospodarz,\n" +
                        "wynik.gole_gosc,\n" +
                        "sedzia.imie,\n" +
                        "sedzia.nazwisko\n" +
                        "from mecz\n" +
                        "join stadion on stadion.id = mecz.stadion_id\n" +
                        "join sedzia on sedzia.id = mecz.sedzia_id\n" +
                        "join wynik on wynik.id = mecz.wynik_id\n" +
                        "JOIN Klub A ON A.id=mecz.gospodarz_id\n" +
                        "JOIN Klub B ON B.id=mecz.gosc_id";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                Integer stadion_id = rs.getInt("stadion_id");
                Integer gospodarz_id = rs.getInt("gospodarz_id");
                Integer gosc_id = rs.getInt("gosc_id");
                Integer wynik_id = rs.getInt("wynik_id");
                Integer sedzia_id = rs.getInt("sedzia_id");
                Integer frekwencja = rs.getInt("frekwencja");
                Date dataspotkania = rs.getDate("dataspotkania");
                String nazwastadionu = rs.getString("nazwastadionu");
                String gospodarznazwa = rs.getString("gospodarznazwa");
                String goscnazwa = rs.getString("goscnazwa");
                Integer gole_gospodarz = rs.getInt("gole_gospodarz");
                Integer gole_gosc = rs.getInt("gole_gosc");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");

                arrayList.add(new Mecz(id, stadion_id, nazwastadionu, gospodarz_id,
                        gospodarznazwa, gosc_id, goscnazwa,
                        wynik_id, gole_gospodarz, gole_gosc, sedzia_id,
                        imie+" "+nazwisko, frekwencja, dataspotkania));
            }
        } catch (SQLException e ) {
            e.printStackTrace();
            System.out.println("Coś się zjebało widok trenerow");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunMecz(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.mecz(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public String proceduraUpdateWynik(Integer id, Integer golegospodarz, Integer golegosc) {
        String error = "";
        try {
            //(p_stadion_id IN NUMBER, p_gospodarz_id IN NUMBER, p_gosc_id IN NUMBER, p_sedzia_id IN NUMBER, p_data IN DATE, crit_error_message OUT VARCHAR2);
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call WYNIK_UPDATE(?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);
            cStmt.setInt(1, id);
            cStmt.setInt(2, golegospodarz);
            cStmt.setInt(3, golegosc);


            cStmt.executeUpdate();

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public String proceduraUpdateFrekwencja(Integer id, Integer iloscOsob) {
        String error = "";
        try {
            //(p_stadion_id IN NUMBER, p_gospodarz_id IN NUMBER, p_gosc_id IN NUMBER, p_sedzia_id IN NUMBER, p_data IN DATE, crit_error_message OUT VARCHAR2);
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call FREKWENCJA_UPDATE(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);
            cStmt.setInt(1, id);
            cStmt.setInt(2, iloscOsob);



            cStmt.executeUpdate();

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public String proceduraZapiszStatystyke(int p_zawodnik, int p_mecz, int p_minuty, int p_gole,int p_asysty, int p_yellow, int p_red) {
        String error = "";
        try {
            //(p_zawodnik IN NUMBER,p_mecz IN NUMBER,p_minuty IN NUMBER,p_gole IN NUMBER,p_asysty IN NUMBER,p_yellow IN NUMBER,p_red IN NUMBER,crit_error_message OUT VARCHAR2);
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.zawodnik_mecz(?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);
            cStmt.setInt(1, p_zawodnik);
            cStmt.setInt(2, p_mecz);
            cStmt.setInt(3, p_minuty);
            cStmt.setInt(4, p_gole);
            cStmt.setInt(5, p_asysty);
            cStmt.setInt(6, p_yellow);
            cStmt.setInt(7, p_red);

            cStmt.registerOutParameter(8, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(8);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<Statystyka> widokStatystyka(int p_zawodnik, int p_mecz) {
        List<Statystyka> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select * from zawodnik_mecz where zawodnik_id ="+p_zawodnik+" and mecz_id="+p_mecz;

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer zawodnik_id = rs.getInt("zawodnik_id");
                Integer mecz_id = rs.getInt("mecz_id");
                Integer ilosc_minut = rs.getInt("ilosc_minut");
                Integer gole = rs.getInt("gole");
                Integer asysty = rs.getInt("asysty");
                Integer zolta_kartka = rs.getInt("zolta_kartka");
                Integer czerwona_kartka = rs.getInt("czerwona_kartka");


                arrayList.add(new Statystyka(zawodnik_id,mecz_id,ilosc_minut,gole,asysty,zolta_kartka,czerwona_kartka));
            }
        } catch (SQLException e ) {
            System.out.println("Coś się zjebało widok trenerow");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }


}
