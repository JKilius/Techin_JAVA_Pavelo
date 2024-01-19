package lt.techin.pavels;

import lt.vtvpmc.java.postoffice.IllegalPackageException;
import lt.vtvpmc.java.postoffice.Package;
import lt.vtvpmc.java.postoffice.PostOffice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostOfficeImplemented implements PostOffice {
    List<Package> inventory = new ArrayList<>();

    @Override
    public void postPackage(Package aPackage) throws IllegalPackageException {
        if (aPackage.getPackageCode() == null || aPackage.getOwner() == null || aPackage.getPackageCode().isBlank() || aPackage.getOwner().isBlank())
            throw new IllegalPackageException();
        inventory.add(aPackage);
    }

    @Override
    public long numberOfPackagesForOwner(String owner) {
        return inventory.stream().filter(pack -> pack.getOwner().equals(owner)).count();
    }

    @Override
    public Package retrievePackage(String packageCode) {
        Package packRet =
                inventory.stream().filter(pack -> pack.getPackageCode().equals(packageCode)).findAny().orElse(null);
        if (packRet != null) inventory.remove(packRet);
        return packRet;
    }
}
