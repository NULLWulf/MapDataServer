package edu.oswegofs.mapdataserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetRepository assetRepository;

    // Assigns Asset Repo to this Controller
    public AssetController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    // Get All Assets from the Database
    @GetMapping("/all")
    public Iterable<Assets> getAllAssets() {
        return assetRepository.findAll();
    }

    // Get Distinct pair liss of Types and Categories
    @GetMapping("/cat_type_list")
    public Iterable<String> getTypeCategoryList(){
        return assetRepository.findAssetIdAndCategory();
    }

    // Get count of all assets in database
    @GetMapping("/count")
    public long count(){
        return assetRepository.count();
    }

    // Get Singular Asset by Asset Id
    @GetMapping("/{id}")
    public Optional<Assets> getId(@PathVariable Long id){
        return assetRepository.findByid(id);
    }
}
