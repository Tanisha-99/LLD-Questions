package observerPackage;

import utilityClasses.Product;

import java.util.List;

public class DashboardNotifier implements InventoryObserver{

    private String alertLevel;
    private List<String> adminUsers;

    public DashboardNotifier(String alertLevel, List<String> adminUsers) {
        this.alertLevel = alertLevel;
        this.adminUsers = adminUsers;
    }

    public void update(Product product) {
        double stockPercentage = ((double)product.getQuantity() / product.getThreshold()) * 100.0;

        if(stockPercentage <= 25) {
            System.out.println("CRITICAL ALERT: " + product.getId() + " stock low at " + product.getQuantity() + " units (" + String.format("%.1f", stockPercentage) + "% of threshold)");
            notifyAdmins(product, "CRITICAL");
        } else if(stockPercentage <= 50) {
            System.out.println("WARNING ALERT: " + product.getId() + " stock low at " + product.getQuantity() + " units (" + String.format("%.1f", stockPercentage) + "% of threshold)");
            notifyAdmins(product, "WARNING");
        }
    }

    private void notifyAdmins(Product product, String alertLevel) {
        for(String adminUser : adminUsers) {
            System.out.println("Dashboard alert sent to admin: " + adminUser + " - " + alertLevel + "level alert for " + product.getId());
        }
    }
}
