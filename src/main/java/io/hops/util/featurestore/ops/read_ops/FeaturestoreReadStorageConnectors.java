package io.hops.util.featurestore.ops.read_ops;

import io.hops.util.Hops;
import io.hops.util.exceptions.FeaturestoreNotFound;
import io.hops.util.featurestore.ops.FeaturestoreOp;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Builder class for Read-Storage Connectors operation on the Hopsworks Featurestore
 */
public class FeaturestoreReadStorageConnectors extends FeaturestoreOp {

  /**
   * Constructor
   */
  public FeaturestoreReadStorageConnectors() {
    super("");
  }
  
  /**
   * Gets a list of all storage connectors from a particular featurestore
   *
   * @throws FeaturestoreNotFound FeaturestoreNotFound
   * @throws JAXBException JAXBException
   * @return a list of storage connectors in the featurestore
   */
  public List<String> read() throws FeaturestoreNotFound, JAXBException {
    return Hops.getFeaturestoreMetadata().setFeaturestore(featurestore).read().
      getStorageConnectors().stream()
      .map(sc -> sc.getName()).collect(Collectors.toList());
  }
  
  /**
   * Method call to execute write operation
   */
  public void write(){
    throw new UnsupportedOperationException("write() is not supported on a read operation");
  }
  
  public FeaturestoreReadStorageConnectors setFeaturestore(String featurestore) {
    this.featurestore = featurestore;
    return this;
  }
  
}
