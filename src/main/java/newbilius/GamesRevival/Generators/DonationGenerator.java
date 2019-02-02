package newbilius.GamesRevival.Generators;

import newbilius.GamesRevival.FileHelper;
import newbilius.GamesRevival.FoldersConfig;
import newbilius.GamesRevival.GeneratorsInfastructure.BaseOnePageGenerator;
import newbilius.GamesRevival.HTML.MDToHtmlConverter;
import newbilius.GamesRevival.HTML.Breadcrumbs.MainBreadcrumbGenerator;

import java.io.IOException;

@SuppressWarnings("unused")
public class DonationGenerator extends BaseOnePageGenerator {
    public DonationGenerator(FoldersConfig foldersConfig) {
        super(foldersConfig);
    }

    @Override
    protected String getFileName() {
        return "donation.html";
    }

    @Override
    protected String getJSFileName() {
        return "";
    }

    @Override
    protected String getContent() throws IOException {
        var builder = new StringBuilder();

        var breadcrumbGenerator = new MainBreadcrumbGenerator();
        breadcrumbGenerator.add("���������");
        builder.append(breadcrumbGenerator.generate());

        var mdToHtmlConverter = new MDToHtmlConverter();
        var faqData = FileHelper.getFileText(foldersConfig.getInputFolder() + "donation.md");
        var text = mdToHtmlConverter.convert(faqData);
        builder.append(text);
        return builder.toString();
    }

    @Override
    protected String getTitle() {
        return "Games Revival - ���������";
    }
}
