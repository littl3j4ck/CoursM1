public class appliServeur {
    public static void main(string[] args) {
    try {
        //1- Création et intialissation de l'orb
        //orb.corba
        ORB orb = ORB.init(args,null);
        //2- obtenir la reference de rootpoa &
        //activer le POAManager
        POA rootpoa = POAHelper.narrow(orb
        .resolve_initial_references("RootPOA"));
        rootpoa.the_POAManager().activate();
        //3.Creation d'un servant hello
        HelloServant HelloRef = new HelloServant();
        //obtenir la reference CORBA du servant
        org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloRef);
        Hello href = HelloHelper.narrow(ref);
        //5.Obtenir la reference du contexte de nommage
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        //6.Utiliser NamingContextExt qui est ineroperable
        NamingContextExt ncRef = NamingContextExthelper.narrow.objRef);
        //enregistrer le servant dans le service de nommage
        String name = "MyHello";
        NameComponent path[] =ncRef.to_name(name);
        ncRef.rebind(path, href);
        System.out.printIn("HelloServer est prêt et en attente.");
        //attendre les invocations des clients.




    }catch (Exception e){
        System.out.printLn(e);
    }
